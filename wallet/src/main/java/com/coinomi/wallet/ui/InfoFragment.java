package com.coinomi.wallet.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
import com.coinomi.wallet.ui.info.CoinInfoData;
import com.coinomi.wallet.ui.info.CoinType;
import com.coinomi.wallet.ui.widget.Amount;

import com.coinomi.wallet.ExchangeRatesProvider.ExchangeRate;
import com.coinomi.wallet.util.WeakHandler;

import org.bitcoinj.core.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.coinomi.wallet.Constants.exchangesName;

public class InfoFragment extends WalletFragment {

    private static final Logger log = LoggerFactory.getLogger(InfoFragment.class);
    private WalletAccount pocket;
    private String accountId;
    private WalletApplication application;
    private ExchangeRate exchangeRate;
    private ArrayAdapter<String> adapter;
    private com.coinomi.core.coins.CoinType type;
    private Configuration config;
    private Coin currentBalance;

    @BindView(R.id.lvExchanges) ListView lvExchanges;
    @BindView(R.id.ivLogo) ImageView ivLogo;
    @BindView(R.id.accountBalance) Amount accountBalance;
    @BindView(R.id.accountExchangedBalance) Amount accountExchangedBalance;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvDescribe) TextView tvDescribe;
    @BindView(R.id.tvTitleSite) TextView tvTitleSite;
    @BindView(R.id.tvTitleTelegram) TextView tvTitleTelegram;
    @BindView(R.id.tvTitleDiscord) TextView tvTitleDiscord;
    @BindView(R.id.tvTitleEmail) TextView tvTitleEmail;

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
        // Required empty public constructor
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
        setupAdapter(inflater);
        accountBalance.setSymbol(type.getSymbol());
        exchangeRate = ExchangeRatesProvider.getRate(
                application.getApplicationContext(), type.getSymbol(), config.getExchangeCurrencyCode());
        updateBalance(pocket.getBalance());
        chooseBlockInfoData();
        return view;
    }

    private void chooseBlockInfoData() {
        if (CoinType.BITCOIN.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_BITCOIN);
        } else if (CoinType.DASH.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_DASH);
        } else if (CoinType.BITCOIN_TURBO_COIN.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_BITCOINTURBOKOIN);
        } else if (CoinType.BITCOIN_ONE.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_BITCOINONE);
        } else if (CoinType.DOGECOIN_PRIVATE.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_DOGECOINPRIVATE);
        }
    }

    private void fillInfoData(HashMap<CoinInfoData, Object> typeCoin) {
        ivLogo.setImageResource(Constants.COINS_ICONS.get(pocket.getCoinType()));
        tvTitle.setText(pocket.getDescriptionOrCoinName());
        tvDescribe.setText(typeCoin.get(CoinInfoData.DESCRIBE).toString());
        tvTitleSite.setText(typeCoin.get(CoinInfoData.SITE).toString());
        tvTitleTelegram.setText(typeCoin.get(CoinInfoData.TELEGRAM).toString());
        tvTitleDiscord.setText(typeCoin.get(CoinInfoData.DISCORD).toString());
        tvTitleEmail.setText(typeCoin.get(CoinInfoData.EMAIL).toString());
    }

    private void setupAdapter(LayoutInflater inflater) {
        adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, exchangesName);
        lvExchanges.setAdapter(adapter);
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
        public void onLoaderReset(final Loader<Cursor> loader) { }
    };

    static class MyHandler extends WeakHandler<InfoFragment> {
        public MyHandler(InfoFragment ref) { super(ref); }

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
