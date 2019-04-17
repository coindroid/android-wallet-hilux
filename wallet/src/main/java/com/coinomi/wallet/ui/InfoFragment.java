package com.coinomi.wallet.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.coinomi.core.coins.Value;
import com.coinomi.core.util.GenericUtils;
import com.coinomi.core.wallet.WalletAccount;
import com.coinomi.wallet.Configuration;
import com.coinomi.wallet.Constants;
import com.coinomi.wallet.ExchangeRatesProvider;
import com.coinomi.wallet.R;
import com.coinomi.wallet.WalletApplication;
import com.coinomi.wallet.ui.info.InfoAdapter;
import com.coinomi.wallet.ui.widget.Amount;

import com.coinomi.wallet.ExchangeRatesProvider.ExchangeRate;
import com.coinomi.wallet.util.WeakHandler;

import org.bitcoinj.core.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.coinomi.wallet.Constants.INFO_EXCHANGES;
import static com.coinomi.wallet.Constants.INFO_SOCIAL;

public class InfoFragment extends WalletFragment {

    private static final Logger log = LoggerFactory.getLogger(InfoFragment.class);
    private WalletAccount pocket;
    private String accountId;
    private WalletApplication application;
    private ExchangeRate exchangeRate;
    private com.coinomi.core.coins.CoinType type;
    private Configuration config;
    private Coin currentBalance;

    @BindView(R.id.lvExchanges)
    ListView lvExchanges;
    @BindView(R.id.lvSocial)
    ListView lvSocial;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.accountBalance)
    Amount accountBalance;
    @BindView(R.id.accountExchangedBalance)
    Amount accountExchangedBalance;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvDescribe)
    TextView tvDescribe;

    private static final int UPDATE_VIEW = 1;
    private static final int WALLET_CHANGED = 0;
    private static final int ID_RATE_LOADER = 1;

    private final MyHandler handler = new MyHandler(this);

    public static InfoFragment newInstance(String accountId) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constants.ARG_ACCOUNT_ID, accountId);
        fragment.setArguments(args);
        return fragment;
    }

    public InfoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            accountId = getArguments().getString(Constants.ARG_ACCOUNT_ID);
        }
        pocket = application.getAccount(accountId);
        if (pocket == null) {
            Toast.makeText(getActivity(), R.string.no_such_pocket_error, Toast.LENGTH_LONG).show();
            return;
        }
        type = pocket.getCoinType();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(ID_RATE_LOADER, null, rateLoaderCallbacks);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        setBinder(ButterKnife.bind(this, view));

        setupExchangesAdapter(INFO_EXCHANGES.get(pocket.getCoinType()));
        setupSocialAdapter(INFO_SOCIAL.get(pocket.getCoinType()));

        accountBalance.setSymbol(type.getSymbol());
        exchangeRate = ExchangeRatesProvider.getRate(
                application.getApplicationContext(), type.getSymbol(), config.getExchangeCurrencyCode());
        updateBalance(pocket.getBalance());
        fillInfoData();
        return view;
    }

    private void fillInfoData() {
        ivLogo.setImageResource(Constants.COINS_ICONS.get(pocket.getCoinType()));
        tvTitle.setText(pocket.getDescriptionOrCoinName().toUpperCase());
        tvDescribe.setText(getResources().getString(Constants.INFO_DESCRIBE.get(pocket.getCoinType())));
    }

    private void setupExchangesAdapter(HashMap<String, String> exchanges) {
        InfoAdapter adapter = new InfoAdapter(exchanges);
        lvExchanges.addHeaderView(createHeader("EXCHANGES:"));
        lvExchanges.setAdapter(adapter);
        lvExchanges.setOnItemClickListener((parent, view, position, id) -> {
            String uri = (String) ((Map.Entry) parent.getAdapter().getItem(position)).getValue();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(browserIntent);
        });
    }

    private void setupSocialAdapter(HashMap<String, String> social) {
        InfoAdapter adapter = new InfoAdapter(social);
        lvSocial.addHeaderView(createHeader("SOCIAL:"));
        lvSocial.setAdapter(adapter);
        lvSocial.setOnItemClickListener((parent, view, position, id) -> {
            String uri = (String) ((Map.Entry) parent.getAdapter().getItem(position)).getValue();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(browserIntent);
        });
    }

    View createHeader(String text) {
        View v = getLayoutInflater().inflate(R.layout.info_adapter_item_header, null);
        ((TextView) v.findViewById(R.id.tvTitleHeader)).setText(text);
        return v;
    }

    @Override
    public WalletAccount getAccount() {
        return pocket;
    }

    private final LoaderManager.LoaderCallbacks<Cursor> rateLoaderCallbacks = new LoaderManager.LoaderCallbacks<Cursor>() {
        @Override
        public Loader<Cursor> onCreateLoader(final int id, final Bundle args) {
            String localSymbol = config.getExchangeCurrencyCode();
            String coinSymbol = type.getSymbol();
            return new ExchangeRateLoader(getActivity(), config, localSymbol, coinSymbol);
        }

        @Override
        public void onLoadFinished(final Loader<Cursor> loader, final Cursor data) {
            if (data != null && data.getCount() > 0) {
                data.moveToFirst();
                exchangeRate = ExchangeRatesProvider.getExchangeRate(data);
                handler.sendEmptyMessage(UPDATE_VIEW);
                if (log.isInfoEnabled()) {
                    try {
                        log.info("Got exchange rate: {}",
                                exchangeRate.rate.convert(type.oneCoin()).toFriendlyString());
                    } catch (Exception e) {
                        log.warn(e.getMessage());
                    }
                }
            }
        }

        @Override
        public void onLoaderReset(final Loader<Cursor> loader) {
        }
    };

    static class MyHandler extends WeakHandler<InfoFragment> {
        public MyHandler(InfoFragment ref) {
            super(ref);
        }

        @Override
        protected void weakHandleMessage(InfoFragment ref, Message msg) {
            switch (msg.what) {
                case WALLET_CHANGED:
                    ref.updateBalance();
                    break;
                case UPDATE_VIEW:
                    ref.updateView();
                    break;
            }
        }
    }

    @Override
    public void updateView() {
        if (isRemoving() || isDetached()) return;
        String newBalanceStr = "1.00";
        accountBalance.setAmount(newBalanceStr);

        if (exchangeRate != null && getView() != null) {
            try {
                Value fiatAmount = exchangeRate.rate.convert(type, Value.parse(type, newBalanceStr).toCoin());
                accountExchangedBalance.setAmount(GenericUtils.formatFiatValue(fiatAmount));
                accountExchangedBalance.setSymbol(fiatAmount.type.getSymbol());
            } catch (Exception e) {
                accountExchangedBalance.setAmount("");
                accountExchangedBalance.setSymbol("ERROR");
            }
        }
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        application = (WalletApplication) context.getApplicationContext();
        config = application.getConfiguration();
    }

    private void updateBalance() {
        updateBalance(pocket.getBalance());
    }

    private void updateBalance(final Value newBalance) {
        currentBalance = newBalance.toCoin();
        updateView();
    }
}
