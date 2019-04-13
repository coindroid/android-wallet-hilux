package com.coinomi.wallet.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.coinomi.core.wallet.WalletAccount;
import com.coinomi.wallet.Constants;
import com.coinomi.wallet.R;
import com.coinomi.wallet.WalletApplication;
import com.coinomi.wallet.ui.info.CoinInfoData;
import com.coinomi.wallet.ui.info.CoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import static com.coinomi.wallet.Constants.exchangesName;

public class InfoFragment extends WalletFragment {

    private static final Logger log = LoggerFactory.getLogger(InfoFragment.class);
    private WalletAccount pocket;
    private String accountId;
    private WalletApplication application;

    ListView lvExchanges;
    ImageView ivLogo;
    TextView tvTitle, tvPrice, tvPriceDescribe,
            tvDescribe, tvTitleSite, tvTitleTelegram,
            tvTitleDiscord, tvTitleEmail;

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
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        lvExchanges = view.findViewById(R.id.lvExchanges);
        ivLogo = view.findViewById(R.id.ivLogo);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvPrice = view.findViewById(R.id.tvPrice);
        tvPriceDescribe = view.findViewById(R.id.tvPriceDescribe);
        tvDescribe = view.findViewById(R.id.tvDescribe);
        tvTitleSite = view.findViewById(R.id.tvTitleSite);
        tvTitleTelegram = view.findViewById(R.id.tvTitleTelegram);
        tvTitleDiscord = view.findViewById(R.id.tvTitleDiscord);
        tvTitleEmail = view.findViewById(R.id.tvTitleEmail);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(),
                android.R.layout.simple_list_item_1, exchangesName);
        lvExchanges.setAdapter(adapter);

        chooseBlockInfoData();
        return view;
    }

    private void chooseBlockInfoData() {
        if (CoinType.BITCOIN.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_BITCOIN);
        } else if (CoinType.DASH.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_DASH);
        } else if(CoinType.BITCOIN_TURBO_COIN.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_BITCOINTURBOKOIN);
        } else if(CoinType.BITCOIN_ONE.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_BITCOINONE);
        } else if(CoinType.DOGECOIN_PRIVATE.getValue().equals(pocket.getDescriptionOrCoinName())) {
            fillInfoData(Constants.COINS_BLOCK_INFO_DOGECOINPRIVATE);
        }
    }

    private void fillInfoData(HashMap<CoinInfoData, Object> typeCoin) {
        ivLogo.setImageResource(Constants.COINS_ICONS.get(pocket.getCoinType()));
        tvTitle.setText(pocket.getDescriptionOrCoinName());
        tvPrice.setText(typeCoin.get(CoinInfoData.PRICE).toString());
        tvPriceDescribe.setText(typeCoin.get(CoinInfoData.PRICE_DESCRIBE).toString());
        tvDescribe.setText(typeCoin.get(CoinInfoData.DESCRIBE).toString());
        tvTitleSite.setText(typeCoin.get(CoinInfoData.SITE).toString());
        tvTitleTelegram.setText(typeCoin.get(CoinInfoData.TELEGRAM).toString());
        tvTitleDiscord.setText(typeCoin.get(CoinInfoData.DISCORD).toString());
        tvTitleEmail.setText(typeCoin.get(CoinInfoData.EMAIL).toString());
    }

    @Override
    public WalletAccount getAccount() {
        return pocket;
    }

    @Override
    public void updateView() {

    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        application = (WalletApplication) context.getApplicationContext();
    }
}
