package com.coinomi.wallet;

import android.text.format.DateUtils;

import com.coinomi.core.coins.BitcoinoneMain;
import com.coinomi.core.coins.BitcoinMain;
import com.coinomi.core.coins.DashMain;
import com.coinomi.core.coins.DogecoinprivateMain;
import com.coinomi.core.coins.BitcointurbokoinMain;

import com.coinomi.core.coins.CoinID;
import com.coinomi.core.coins.CoinType;
import com.coinomi.core.network.CoinAddress;
import com.coinomi.stratumj.ServerAddress;
import com.coinomi.wallet.ui.NavDrawerItem;
import com.google.common.collect.ImmutableList;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author John L. Jegutanis
 * @author Andreas Schildbach
 */
public class Constants {

    public static final boolean USE_FULL_TOP = false;

    public static final boolean DRAWER_LOCKED = false;
    public static final boolean ADD_COINS_LOCKED = false;

    public static final int SEED_ENTROPY_DEFAULT = 192;
    public static final int SEED_ENTROPY_EXTRA = 256;

    public static final String ARG_SEED = "seed";
    public static final String ARG_PASSWORD = "password";
    public static final String ARG_SEED_PASSWORD = "seed_password";
    public static final String ARG_EMPTY_WALLET = "empty_wallet";
    public static final String ARG_SEND_TO_ADDRESS = "send_to_address";
    public static final String ARG_SEND_TO_COIN_TYPE = "send_to_coin_type";
    public static final String ARG_SEND_TO_ACCOUNT_ID = "send_to_account_id";
    public static final String ARG_SEND_VALUE = "send_value";
    public static final String ARG_TX_MESSAGE = "tx_message";
    public static final String ARG_COIN_ID = "coin_id";
    public static final String ARG_ACCOUNT_ID = "account_id";
    public static final String ARG_MULTIPLE_COIN_IDS = "multiple_coin_ids";
    public static final String ARG_MULTIPLE_CHOICE = "multiple_choice";
    public static final String ARG_SEND_REQUEST = "send_request";
    public static final String ARG_TRANSACTION_ID = "transaction_id";
    public static final String ARG_ERROR = "error";
    public static final String ARG_MESSAGE = "message";
    public static final String ARG_ADDRESS = "address";
    public static final String ARG_ADDRESS_STRING = "address_string";
    public static final String ARG_EXCHANGE_ENTRY = "exchange_entry";
    public static final String ARG_URI = "test_wallet";
    public static final String ARG_PRIVATE_KEY = "private_key";
    public static final String ARG_ADDRESS_TYPE_ERROR = "address_type_error";

    public static final int PERMISSIONS_REQUEST_CAMERA = 0;

    public static final String WALLET_FILENAME_PROTOBUF = "wallet";
    public static final long WALLET_WRITE_DELAY = 5;
    public static final TimeUnit WALLET_WRITE_DELAY_UNIT = TimeUnit.SECONDS;

    public static final long STOP_SERVICE_AFTER_IDLE_SECS = 30 * 60; // 30 mins

    public static final String HTTP_CACHE_NAME = "http_cache";
    public static final int HTTP_CACHE_SIZE = 256 * 1024; // 256 KiB
    public static final int NETWORK_TIMEOUT_MS = 15 * (int) DateUtils.SECOND_IN_MILLIS;

    public static final String TX_CACHE_NAME = "tx_cache";
    public static final int TX_CACHE_SIZE = 5 * 1024 * 1024; // 5 MiB, TODO currently not enforced

    public static final long RATE_UPDATE_FREQ_MS = 30 * DateUtils.SECOND_IN_MILLIS;

    /**
     * Default currency to use if all default mechanisms fail.
     */
    public static final String DEFAULT_EXCHANGE_CURRENCY = "USD";

    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");

    public static final char CHAR_HAIR_SPACE = '\u200a';
    public static final char CHAR_THIN_SPACE = '\u2009';
    public static final char CHAR_ALMOST_EQUAL_TO = '\u2248';
    public static final char CHAR_CHECKMARK = '\u2713';
    public static final char CURRENCY_PLUS_SIGN = '+';
    public static final char CURRENCY_MINUS_SIGN = '-';

    public static final String MARKET_APP_URL = "market://details?id=%s";
    public static final String BINARY_URL = "https://github.com/Hilux/Hilux/releases";

    public static final String VERSION_URL = "https://www.b_one_payment.ioversion";
    public static final String PARTNERS_URI = "https://www.b_one_payment.iopartner.json";
    public static final String SUPPORT_EMAIL = "support@bonepayment.com";

    // TODO move to resource files
    public static final List<CoinAddress> DEFAULT_COINS_SERVERS = ImmutableList.of(
            new CoinAddress(BitcoinMain.get(), new ServerAddress("btc-cce-1.coinomi.net", 5001),
                    new ServerAddress("btc-cce-2.coinomi.net", 5001)),


            new CoinAddress(DashMain.get(), new ServerAddress("drk-cce-1.coinomi.net", 5013),
                    new ServerAddress("drk-cce-2.coinomi.net", 5013)),

            new CoinAddress(BitcoinoneMain.get(), new ServerAddress("45.32.237.148", 9100),
                    new ServerAddress("45.32.237.148", 9100)),

            new CoinAddress(DogecoinprivateMain.get(), new ServerAddress("95.179.189.149", 1111),
                    new ServerAddress("95.179.189.149", 1111)),

            new CoinAddress(BitcointurbokoinMain.get(), new ServerAddress("45.77.137.171", 1111),
                    new ServerAddress("45.77.137.171", 1111))

    );

    public static final LinkedHashMap<CoinType, Integer> COINS_ICONS;
    public static final LinkedHashMap<CoinType, String> COINS_BLOCK_EXPLORERS;

    public static final LinkedHashMap<CoinType, HashMap<String, String>> INFO_EXCHANGES;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_DOGECOINPRIVATE;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOINTURBOKOIN;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOINONE;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOIN;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_DASH;

    public static final LinkedHashMap<CoinType, HashMap<String, String>> INFO_SOCIAL;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_DOGECOINPRIVATE;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOINTURBOKOIN;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOINONE;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOIN;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_DASH;

    public static final LinkedHashMap<CoinType, HashMap<String, String>> INFO_MARKETCAP;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_DOGECOINPRIVATE;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOINTURBOKOIN;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOINONE;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOIN;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_DASH;

    public static final LinkedHashMap<CoinType, Integer> INFO_DESCRIBE;

    static {
        COINS_ICONS = new LinkedHashMap<>();
        COINS_ICONS.put(CoinID.BITCOINONE_MAIN.getCoinType(), R.drawable.bitcoinone);
        COINS_ICONS.put(CoinID.BITCOIN_MAIN.getCoinType(), R.drawable.bitcoin);
        COINS_ICONS.put(CoinID.DASH_MAIN.getCoinType(), R.drawable.dash);
        COINS_ICONS.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), R.drawable.dogecoinprivate);
        COINS_ICONS.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), R.drawable.bitcointurbokoin);

        COINS_BLOCK_EXPLORERS = new LinkedHashMap<>();
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOIN_MAIN.getCoinType(), "https://blockchain.info/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DASH_MAIN.getCoinType(), "http://explorer.dashpay.io/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINONE_MAIN.getCoinType(), "http://explorer.bitcoinone.io/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), "http://explorer.dogecoinprivate.dog/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), "http://explorer.bitcointurbokoin.com/tx/%s");

        //------------------------------------Info-Describe-----------------------------------------
        INFO_DESCRIBE = new LinkedHashMap<>();
        INFO_DESCRIBE.put(CoinID.BITCOIN_MAIN.getCoinType(), R.string.info_describe_bitcoin);
        INFO_DESCRIBE.put(CoinID.DASH_MAIN.getCoinType(), R.string.info_describe_dash);
        INFO_DESCRIBE.put(CoinID.BITCOINONE_MAIN.getCoinType(), R.string.info_describe_bitcoinone);
        INFO_DESCRIBE.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), R.string.info_describe_turbocoin);
        INFO_DESCRIBE.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), R.string.info_describe_dogecoin_private);


        //------------------------------------Info-Exchanges----------------------------------------
        INFO_EXCHANGES_BITCOIN = new LinkedHashMap<>();
        INFO_EXCHANGES_BITCOIN.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_BITCOIN.put("BITTREX", "https://www.bittrex.com");
        INFO_EXCHANGES_BITCOIN.put("COINBASE", "https://www.coinbase.com");

        INFO_EXCHANGES_BITCOINONE = new LinkedHashMap<>();
        INFO_EXCHANGES_BITCOINONE.put("STEX", "https://app.stex.com/en/basic-trade/pair/BTC/BTCONE/1D");
        INFO_EXCHANGES_BITCOINONE.put("GRAVIEX", "https://graviex.net/markets/btconebtc");
        INFO_EXCHANGES_BITCOINONE.put("ESCODEX", "https://wallet.escodex.com/market/ESCODEX.BTCONE_ESCODEX.BTC");
        INFO_EXCHANGES_BITCOINONE.put("FINEXBOX", "https://www.finexbox.com/market/pair/BTCONE-BTC.html");
        INFO_EXCHANGES_BITCOINONE.put("ALTILLY", "https://www.altilly.com/market/BTCONE_BTC");

        INFO_EXCHANGES_DASH = new LinkedHashMap<>();
        INFO_EXCHANGES_DASH.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_DASH.put("BITTREX", "https://www.bittrex.com");

        INFO_EXCHANGES_BITCOINTURBOKOIN = new LinkedHashMap<>();
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("CREX24", "https://crex24.com/exchange/BTK-BTC");
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("STEX", "https://app.stex.com/en/trade/pair/LTC/BTK/1D");
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("MERCATOX BTC", "https://mercatox.com/exchange/BTK/BTC");
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("MERCATOX ETH", "https://mercatox.com/exchange/BTK/ETH");
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("COINDEAL", "https://frontend.coindeal.com/market/trade.html?pair=BTK/XRP");

        INFO_EXCHANGES_DOGECOINPRIVATE = new LinkedHashMap<>();
        INFO_EXCHANGES_DOGECOINPRIVATE.put("NOVAEXCHANGE", "https://novaexchange.com/market/BTC_DOGP");
        INFO_EXCHANGES_DOGECOINPRIVATE.put("ESCODEX", "https://wallet.escodex.com/market/ESCODEX.DOGP_ESCODEX.BTC");
        INFO_EXCHANGES_DOGECOINPRIVATE.put("ALTILLY", "https://www.altilly.com/market/DOGP_DOGE");
        INFO_EXCHANGES_DOGECOINPRIVATE.put("WADAX", "https://wadax.io/trade/DOGPBTC");
        INFO_EXCHANGES_DOGECOINPRIVATE.put("ENMANET", "https://www.enmanet.com/market/BTC-DOGP");

        INFO_EXCHANGES = new LinkedHashMap<>();
        INFO_EXCHANGES.put(CoinID.BITCOIN_MAIN.getCoinType(), INFO_EXCHANGES_BITCOIN);
        INFO_EXCHANGES.put(CoinID.DASH_MAIN.getCoinType(), INFO_EXCHANGES_DASH);
        INFO_EXCHANGES.put(CoinID.BITCOINONE_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINONE);
        INFO_EXCHANGES.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINTURBOKOIN);
        INFO_EXCHANGES.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), INFO_EXCHANGES_DOGECOINPRIVATE);

        //------------------------------------Info-Social-------------------------------------------
        INFO_SOCIAL_BITCOIN = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOIN.put("WEBSITE", "https://en.wikipedia.org/wiki/Bitcoin");

        INFO_SOCIAL_BITCOINONE = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOINONE.put("WEBSITE", "https://www.bitcoinone.io");
        INFO_SOCIAL_BITCOINONE.put("TWITTER", "https://www.twitter.com/thebitcoinone");
        INFO_SOCIAL_BITCOINONE.put("DISCORD", "https://t.me/THEBitCoinONE");

        INFO_SOCIAL_DASH = new LinkedHashMap<>();
        INFO_SOCIAL_DASH.put("WEBSITE", "https://www.dash.org");
        INFO_SOCIAL_DASH.put("TWITTER", "https://twitter.com/Dashpay");
        INFO_SOCIAL_DASH.put("DISCORD", "https://discord.gg/da4UEsq");

        INFO_SOCIAL_BITCOINTURBOKOIN = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOINTURBOKOIN.put("WEBSITE", "https://www.bitcointurbokoin.com");
        INFO_SOCIAL_BITCOINTURBOKOIN.put("TWITTER", "https://twitter.com/bitcoin_token");
        INFO_SOCIAL_BITCOINTURBOKOIN.put("DISCORD", "https://t.me/bitcointurbokoin");

        INFO_SOCIAL_DOGECOINPRIVATE = new LinkedHashMap<>();
        INFO_SOCIAL_DOGECOINPRIVATE.put("WEBSITE", "https://www.dogecoinprivate.dog");
        INFO_SOCIAL_DOGECOINPRIVATE.put("TWITTER", "https://twitter.com/PrivateDOGP");
        INFO_SOCIAL_DOGECOINPRIVATE.put("DISCORD", "https://discord.gg/8u2TVCZ");

        INFO_SOCIAL = new LinkedHashMap<>();
        INFO_SOCIAL.put(CoinID.BITCOIN_MAIN.getCoinType(), INFO_SOCIAL_BITCOIN);
        INFO_SOCIAL.put(CoinID.DASH_MAIN.getCoinType(), INFO_SOCIAL_DASH);
        INFO_SOCIAL.put(CoinID.BITCOINONE_MAIN.getCoinType(), INFO_SOCIAL_BITCOINONE);
        INFO_SOCIAL.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), INFO_SOCIAL_BITCOINTURBOKOIN);
        INFO_SOCIAL.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), INFO_SOCIAL_DOGECOINPRIVATE);

        //------------------------------------Info-Marketcap----------------------------------------

        INFO_MARKETCAP_BITCOIN = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOIN.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin/#markets");

        INFO_MARKETCAP_BITCOINONE = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOINONE.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin-one/#markets");

        INFO_MARKETCAP_DASH = new LinkedHashMap<>();
        INFO_MARKETCAP_DASH.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/dash/#markets");

        INFO_MARKETCAP_BITCOINTURBOKOIN = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOINTURBOKOIN.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin-token/#markets");

        INFO_MARKETCAP_DOGECOINPRIVATE = new LinkedHashMap<>();
        INFO_MARKETCAP_DOGECOINPRIVATE.put("COINGECKO", "https://www.coingecko.com/en/coins/dogecoin-private/trading_exchanges");

        INFO_MARKETCAP = new LinkedHashMap<>();
        INFO_MARKETCAP.put(CoinID.BITCOIN_MAIN.getCoinType(), INFO_MARKETCAP_BITCOIN);
        INFO_MARKETCAP.put(CoinID.DASH_MAIN.getCoinType(), INFO_MARKETCAP_DASH);
        INFO_MARKETCAP.put(CoinID.BITCOINONE_MAIN.getCoinType(), INFO_MARKETCAP_BITCOINONE);
        INFO_MARKETCAP.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), INFO_MARKETCAP_BITCOINTURBOKOIN);
        INFO_MARKETCAP.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), INFO_MARKETCAP_DOGECOINPRIVATE);
    }

    public static final CoinType DEFAULT_COIN = BitcoinMain.get();
    public static final List<CoinType> DEFAULT_COINS = ImmutableList.of((CoinType) BitcoinMain.get());

    public static final List<CoinType> SUPPORTED_COINS = ImmutableList.of(
            BitcoinMain.get(),
            DashMain.get(),
            BitcoinoneMain.get(),
            BitcointurbokoinMain.get(),
            DogecoinprivateMain.get()
    );

    public static void createNavDrawerItemsSecond(List<NavDrawerItem> navDrawerItemsSecond) {
        navDrawerItemsSecond.clear();
        //   NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_SECTION_TITLE, "Buy & Exchange");
        //   NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "CryptoBridge", R.drawable.cryptobridge_logo, "https://wallet.crypto-bridge.org/market/BRIDGE.HLX_BRIDGE.BTC");
        //   NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Escodex", R.drawable.escodex_logo, "https://wallet.escodex.com/market/ESCODEX.HLX_ESCODEX.BTC");
        //  NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Discord", R.drawable.discord_logo, "https://discord.gg/sQfYNbT");

    }
}