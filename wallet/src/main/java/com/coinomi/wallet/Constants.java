package com.coinomi.wallet;

import android.text.format.DateUtils;

import com.coinomi.core.coins.BitcoinCashMain;
import com.coinomi.core.coins.BitcoinGoldMain;
import com.coinomi.core.coins.BitcoinSvMain;
import com.coinomi.core.coins.BitcoinoneMain;
import com.coinomi.core.coins.DogecoinMain;
import com.coinomi.core.coins.LitecoinMain;
import com.coinomi.core.coins.BitcoinMain;
import com.coinomi.core.coins.DashMain;
import com.coinomi.core.coins.DogecoinprivateMain;
import com.coinomi.core.coins.BitcointurbokoinMain;

import com.coinomi.core.coins.CoinID;
import com.coinomi.core.coins.CoinType;
import com.coinomi.core.coins.PivxMain;
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

            new CoinAddress(LitecoinMain.get(), new ServerAddress("ltc-cce-1.coinomi.net", 5002),
                    new ServerAddress("ltc-cce-2.coinomi.net", 5002)),

            new CoinAddress(DogecoinMain.get(), new ServerAddress("doge-cce-1.coinomi.net", 5003),
                    new ServerAddress("doge-cce-2.coinomi.net", 5003)),

            new CoinAddress(DashMain.get(), new ServerAddress("drk-cce-1.coinomi.net", 5013),
                    new ServerAddress("drk-cce-2.coinomi.net", 5013)),

            new CoinAddress(PivxMain.get(), new ServerAddress("pivx-cce-1.coinomi.net", 5063),
                    new ServerAddress("pivx-cce-2.coinomi.net", 5063)),

            new CoinAddress(BitcoinCashMain.get(), new ServerAddress("176.9.65.41", 5090),
                    new ServerAddress("148.251.52.199", 5090)),

            new CoinAddress(BitcoinSvMain.get(), new ServerAddress("213.133.103.103", 5104),
                    new ServerAddress("213.239.216.162", 5104)),

            new CoinAddress(BitcoinGoldMain.get(), new ServerAddress("213.239.216.162", 5105),
                    new ServerAddress("213.133.103.103", 5105)),

            new CoinAddress(BitcoinoneMain.get(), new ServerAddress("45.32.237.148", 9100),
                    new ServerAddress("45.32.237.148", 9100)),

            new CoinAddress(BitcointurbokoinMain.get(), new ServerAddress("45.77.137.171", 1111),
                    new ServerAddress("45.77.137.171", 1111)),

            new CoinAddress(DogecoinprivateMain.get(), new ServerAddress("95.179.189.149", 1111),
                    new ServerAddress("95.179.189.149", 1111))
    );

    public static final LinkedHashMap<CoinType, Integer> COINS_ICONS;
    public static final LinkedHashMap<CoinType, String> COINS_BLOCK_EXPLORERS;

    public static final LinkedHashMap<CoinType, HashMap<String, String>> INFO_EXCHANGES;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOIN;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_LITECOIN;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_DOGECOIN;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_DASH;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_PIVX;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOINCASH;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOINSV;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOINGOLD;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOINONE;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_BITCOINTURBOKOIN;
    public static final LinkedHashMap<String, String> INFO_EXCHANGES_DOGECOINPRIVATE;

    public static final LinkedHashMap<CoinType, HashMap<String, String>> INFO_SOCIAL;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOIN;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_LITECOIN;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_DOGECOIN;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_DASH;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_PIVX;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOINCASH;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOINSV;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOINGOLD;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOINONE;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_BITCOINTURBOKOIN;
    public static final LinkedHashMap<String, String> INFO_SOCIAL_DOGECOINPRIVATE;

    public static final LinkedHashMap<CoinType, HashMap<String, String>> INFO_MARKETCAP;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOIN;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_LITECOIN;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_DOGECOIN;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_DASH;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_PIVX;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOINCASH;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOINSV;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOINGOLD;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOINONE;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_BITCOINTURBOKOIN;
    public static final LinkedHashMap<String, String> INFO_MARKETCAP_DOGECOINPRIVATE;

    public static final LinkedHashMap<CoinType, Integer> INFO_DESCRIBE;

    static {
        COINS_ICONS = new LinkedHashMap<>();
        COINS_ICONS.put(CoinID.BITCOIN_MAIN.getCoinType(), R.drawable.bitcoin);
        COINS_ICONS.put(CoinID.LITECOIN_MAIN.getCoinType(), R.drawable.litecoin);
        COINS_ICONS.put(CoinID.DOGECOIN_MAIN.getCoinType(), R.drawable.dogecoin);
        COINS_ICONS.put(CoinID.DASH_MAIN.getCoinType(), R.drawable.dash);
        COINS_ICONS.put(CoinID.PIVX_MAIN.getCoinType(), R.drawable.pivx);
        COINS_ICONS.put(CoinID.BITCOINCASH_MAIN.getCoinType(), R.drawable.btccash);
        COINS_ICONS.put(CoinID.BITCOINSV_MAIN.getCoinType(), R.drawable.bitcoinsv);
        COINS_ICONS.put(CoinID.BITCOINGOLD_MAIN.getCoinType(), R.drawable.btcgold);
        COINS_ICONS.put(CoinID.BITCOINONE_MAIN.getCoinType(), R.drawable.bitcoinone);
        COINS_ICONS.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), R.drawable.bitcointurbokoin);
        COINS_ICONS.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), R.drawable.dogecoinprivate);

        COINS_BLOCK_EXPLORERS = new LinkedHashMap<>();
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOIN_MAIN.getCoinType(), "https://blockchain.info/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.LITECOIN_MAIN.getCoinType(), "http://ltc.blockr.io/tx/info/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DOGECOIN_MAIN.getCoinType(), "https://chain.so/tx/DOGE/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DASH_MAIN.getCoinType(), "http://explorer.dashpay.io/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.PIVX_MAIN.getCoinType(), "https://explorer.pivx.link/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINCASH_MAIN.getCoinType(), "https://blockchair.com/bitcoin-cash/transaction/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINSV_MAIN.getCoinType(), "https://bchsvexplorer.com/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINGOLD_MAIN.getCoinType(), "https://btgexplorer.com/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINONE_MAIN.getCoinType(), "http://explorer.bitcoinone.io/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), "http://explorer.bitcointurbokoin.com/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), "http://explorer.dogecoinprivate.dog/tx/%s");

        //------------------------------------Info-Describe-----------------------------------------
        INFO_DESCRIBE = new LinkedHashMap<>();
        INFO_DESCRIBE.put(CoinID.BITCOIN_MAIN.getCoinType(), R.string.info_describe_bitcoin);
        INFO_DESCRIBE.put(CoinID.LITECOIN_MAIN.getCoinType(), R.string.info_describe_litecoin);
        INFO_DESCRIBE.put(CoinID.DOGECOIN_MAIN.getCoinType(), R.string.info_describe_dogecoin);
        INFO_DESCRIBE.put(CoinID.DASH_MAIN.getCoinType(), R.string.info_describe_dash);
        INFO_DESCRIBE.put(CoinID.PIVX_MAIN.getCoinType(), R.string.info_describe_pivx);
        INFO_DESCRIBE.put(CoinID.BITCOINCASH_MAIN.getCoinType(), R.string.info_describe_bitcoin_cash);
        INFO_DESCRIBE.put(CoinID.BITCOINSV_MAIN.getCoinType(), R.string.info_describe_bitcoin_sv);
        INFO_DESCRIBE.put(CoinID.BITCOINGOLD_MAIN.getCoinType(), R.string.info_describe_bitcoin_gold);
        INFO_DESCRIBE.put(CoinID.BITCOINONE_MAIN.getCoinType(), R.string.info_describe_bitcoin_one);
        INFO_DESCRIBE.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), R.string.info_describe_turbocoin);
        INFO_DESCRIBE.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), R.string.info_describe_dogecoin_private);


        //------------------------------------Info-Exchanges----------------------------------------
        INFO_EXCHANGES_BITCOIN = new LinkedHashMap<>();
        INFO_EXCHANGES_BITCOIN.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_BITCOIN.put("BITTREX", "https://www.bittrex.com");
        INFO_EXCHANGES_BITCOIN.put("COINBASE", "https://www.coinbase.com");

        INFO_EXCHANGES_LITECOIN = new LinkedHashMap<>();
        INFO_EXCHANGES_LITECOIN.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_LITECOIN.put("BITTREX", "https://www.bittrex.com");

        INFO_EXCHANGES_DOGECOIN = new LinkedHashMap<>();
        INFO_EXCHANGES_DOGECOIN.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_DOGECOIN.put("COINBASE", "https://www.coinbase.com");

        INFO_EXCHANGES_PIVX = new LinkedHashMap<>();
        INFO_EXCHANGES_PIVX.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_PIVX.put("COINBASE", "https://www.coinbase.com");

        INFO_EXCHANGES_DASH = new LinkedHashMap<>();
        INFO_EXCHANGES_DASH.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_DASH.put("BITTREX", "https://www.bittrex.com");

        INFO_EXCHANGES_BITCOINCASH = new LinkedHashMap<>();
        INFO_EXCHANGES_BITCOINCASH.put("COINBASE", "https://www.coinbase.com");
        INFO_EXCHANGES_BITCOINCASH.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_BITCOINCASH.put("BITTREX", "https://www.bittrex.com");

        INFO_EXCHANGES_BITCOINSV = new LinkedHashMap<>();
        INFO_EXCHANGES_BITCOINSV.put("BITTREX", "https://www.bittrex.com");
        INFO_EXCHANGES_BITCOINSV.put("BITFINEX", "https://www.bitfinex.com");

        INFO_EXCHANGES_BITCOINGOLD = new LinkedHashMap<>();
        INFO_EXCHANGES_BITCOINGOLD.put("BINANCE", "https://www.binance.com");
        INFO_EXCHANGES_BITCOINGOLD.put("BITTREX", "https://www.bittrex.com");

        INFO_EXCHANGES_BITCOINONE = new LinkedHashMap<>();
        INFO_EXCHANGES_BITCOINONE.put("STEX", "https://app.stex.com/en/basic-trade/pair/BTC/BTCONE/1D");
        INFO_EXCHANGES_BITCOINONE.put("GRAVIEX", "https://graviex.net/markets/btconebtc");
        INFO_EXCHANGES_BITCOINONE.put("ESCODEX", "https://wallet.escodex.com/market/ESCODEX.BTCONE_ESCODEX.BTC");
        INFO_EXCHANGES_BITCOINONE.put("FINEXBOX", "https://www.finexbox.com/market/pair/BTCONE-BTC.html");
        INFO_EXCHANGES_BITCOINONE.put("ALTILLY", "https://www.altilly.com/market/BTCONE_BTC");

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
        INFO_EXCHANGES.put(CoinID.LITECOIN_MAIN.getCoinType(), INFO_EXCHANGES_LITECOIN);
        INFO_EXCHANGES.put(CoinID.DOGECOIN_MAIN.getCoinType(), INFO_EXCHANGES_DOGECOIN);
        INFO_EXCHANGES.put(CoinID.DASH_MAIN.getCoinType(), INFO_EXCHANGES_DASH);
        INFO_EXCHANGES.put(CoinID.PIVX_MAIN.getCoinType(), INFO_EXCHANGES_PIVX);
        INFO_EXCHANGES.put(CoinID.BITCOINCASH_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINCASH);
        INFO_EXCHANGES.put(CoinID.BITCOINSV_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINSV);
        INFO_EXCHANGES.put(CoinID.BITCOINGOLD_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINGOLD);
        INFO_EXCHANGES.put(CoinID.BITCOINONE_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINONE);
        INFO_EXCHANGES.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINTURBOKOIN);
        INFO_EXCHANGES.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), INFO_EXCHANGES_DOGECOINPRIVATE);

        //------------------------------------Info-Social-------------------------------------------
        INFO_SOCIAL_BITCOIN = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOIN.put("WEBSITE", "https://en.wikipedia.org/wiki/Bitcoin");

        INFO_SOCIAL_LITECOIN = new LinkedHashMap<>();
        INFO_SOCIAL_LITECOIN.put("WEBSITE", "https://en.wikipedia.org/wiki/Litecoin");
        INFO_SOCIAL_LITECOIN.put("TWITTER", "https://twitter.com/Litecoin");
        INFO_SOCIAL_LITECOIN.put("TELEGRAM", "https://telegram.me/litecoin");

        INFO_SOCIAL_DOGECOIN = new LinkedHashMap<>();
        INFO_SOCIAL_DOGECOIN.put("WEBSITE", "https://dogecoin.com");
        INFO_SOCIAL_DOGECOIN.put("TWITTER", "https://twitter.com/dogecoin");
        INFO_SOCIAL_DOGECOIN.put("REDDIT", "http://www.reddit.com/r/dogecoin");

        INFO_SOCIAL_PIVX = new LinkedHashMap<>();
        INFO_SOCIAL_PIVX.put("WEBSITE", "http://www.pivx.org");
        INFO_SOCIAL_PIVX.put("TWITTER", "https://twitter.com/_pivx");
        INFO_SOCIAL_PIVX.put("TELEGRAM", "https://t.me/PIVXChat");

        INFO_SOCIAL_DASH = new LinkedHashMap<>();
        INFO_SOCIAL_DASH.put("WEBSITE", "https://www.dash.org");
        INFO_SOCIAL_DASH.put("TWITTER", "https://twitter.com/Dashpay");
        INFO_SOCIAL_DASH.put("DISCORD", "https://discord.gg/da4UEsq");

        INFO_SOCIAL_BITCOINCASH = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOINCASH.put("WEBSITE", "https://www.bitcoin.com");
        INFO_SOCIAL_BITCOINCASH.put("TWITTER", "https://twitter.com/bitcoin");
        INFO_SOCIAL_BITCOINCASH.put("TELEGRAM", "https://t.me/BitcoinCashUpdates");

        INFO_SOCIAL_BITCOINSV = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOINSV.put("WEBSITE", "https://bitcoinsv.io");
        INFO_SOCIAL_BITCOINSV.put("TWITTER", "https://twitter.com/_BitcoinSV");

        INFO_SOCIAL_BITCOINGOLD = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOINGOLD.put("WEBSITE", "https://bitcoingold.org");
        INFO_SOCIAL_BITCOINGOLD.put("TWITTER", "https://twitter.com/bitcoingold");
        INFO_SOCIAL_BITCOINGOLD.put("TELEGRAM", "https://t.me/BitcoinGoldHQ");

        INFO_SOCIAL_BITCOINONE = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOINONE.put("WEBSITE", "https://www.bitcoinone.io");
        INFO_SOCIAL_BITCOINONE.put("TWITTER", "https://www.twitter.com/thebitcoinone");
        INFO_SOCIAL_BITCOINONE.put("TELEGRAM", "https://t.me/THEBitCoinONE");

        INFO_SOCIAL_BITCOINTURBOKOIN = new LinkedHashMap<>();
        INFO_SOCIAL_BITCOINTURBOKOIN.put("WEBSITE", "https://www.bitcointurbokoin.com");
        INFO_SOCIAL_BITCOINTURBOKOIN.put("TWITTER", "https://twitter.com/bitcoin_token");
        INFO_SOCIAL_BITCOINTURBOKOIN.put("TELEGRAM", "https://t.me/bitcointurbokoin");

        INFO_SOCIAL_DOGECOINPRIVATE = new LinkedHashMap<>();
        INFO_SOCIAL_DOGECOINPRIVATE.put("WEBSITE", "https://www.dogecoinprivate.dog");
        INFO_SOCIAL_DOGECOINPRIVATE.put("TWITTER", "https://twitter.com/PrivateDOGP");
        INFO_SOCIAL_DOGECOINPRIVATE.put("DISCORD", "https://discord.gg/8u2TVCZ");

        INFO_SOCIAL = new LinkedHashMap<>();
        INFO_SOCIAL.put(CoinID.BITCOIN_MAIN.getCoinType(), INFO_SOCIAL_BITCOIN);
        INFO_SOCIAL.put(CoinID.LITECOIN_MAIN.getCoinType(), INFO_SOCIAL_LITECOIN);
        INFO_SOCIAL.put(CoinID.DOGECOIN_MAIN.getCoinType(), INFO_SOCIAL_DOGECOIN);
        INFO_SOCIAL.put(CoinID.DASH_MAIN.getCoinType(), INFO_SOCIAL_DASH);
        INFO_SOCIAL.put(CoinID.PIVX_MAIN.getCoinType(), INFO_SOCIAL_PIVX);
        INFO_SOCIAL.put(CoinID.BITCOINCASH_MAIN.getCoinType(), INFO_SOCIAL_BITCOINCASH);
        INFO_SOCIAL.put(CoinID.BITCOINSV_MAIN.getCoinType(), INFO_SOCIAL_BITCOINSV);
        INFO_SOCIAL.put(CoinID.BITCOINGOLD_MAIN.getCoinType(), INFO_SOCIAL_BITCOINGOLD);
        INFO_SOCIAL.put(CoinID.BITCOINONE_MAIN.getCoinType(), INFO_SOCIAL_BITCOINONE);
        INFO_SOCIAL.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), INFO_SOCIAL_BITCOINTURBOKOIN);
        INFO_SOCIAL.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), INFO_SOCIAL_DOGECOINPRIVATE);

        //------------------------------------Info-Marketcap----------------------------------------

        INFO_MARKETCAP_BITCOIN = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOIN.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin/#markets");

        INFO_MARKETCAP_LITECOIN = new LinkedHashMap<>();
        INFO_MARKETCAP_LITECOIN.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/litecoin/");

        INFO_MARKETCAP_DOGECOIN = new LinkedHashMap<>();
        INFO_MARKETCAP_DOGECOIN.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/dogecoin/");

        INFO_MARKETCAP_PIVX = new LinkedHashMap<>();
        INFO_MARKETCAP_PIVX.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/pivx");

        INFO_MARKETCAP_DASH = new LinkedHashMap<>();
        INFO_MARKETCAP_DASH.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/dash/#markets");

        INFO_MARKETCAP_BITCOINCASH = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOINCASH.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin-cash/");

        INFO_MARKETCAP_BITCOINSV = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOINSV.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin-sv");

        INFO_MARKETCAP_BITCOINGOLD = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOINGOLD.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin-gold/");

        INFO_MARKETCAP_BITCOINONE = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOINONE.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin-one/#markets");

        INFO_MARKETCAP_BITCOINTURBOKOIN = new LinkedHashMap<>();
        INFO_MARKETCAP_BITCOINTURBOKOIN.put("COINMARKETCAP", "https://coinmarketcap.com/currencies/bitcoin-token/#markets");

        INFO_MARKETCAP_DOGECOINPRIVATE = new LinkedHashMap<>();
        INFO_MARKETCAP_DOGECOINPRIVATE.put("COINGECKO", "https://www.coingecko.com/en/coins/dogecoin-private/trading_exchanges");

        INFO_MARKETCAP = new LinkedHashMap<>();
        INFO_MARKETCAP.put(CoinID.BITCOIN_MAIN.getCoinType(), INFO_MARKETCAP_BITCOIN);
        INFO_MARKETCAP.put(CoinID.LITECOIN_MAIN.getCoinType(), INFO_MARKETCAP_LITECOIN);
        INFO_MARKETCAP.put(CoinID.DOGECOIN_MAIN.getCoinType(), INFO_MARKETCAP_DOGECOIN);
        INFO_MARKETCAP.put(CoinID.DASH_MAIN.getCoinType(), INFO_MARKETCAP_DASH);
        INFO_MARKETCAP.put(CoinID.PIVX_MAIN.getCoinType(), INFO_MARKETCAP_PIVX);
        INFO_MARKETCAP.put(CoinID.BITCOINCASH_MAIN.getCoinType(), INFO_MARKETCAP_BITCOINCASH);
        INFO_MARKETCAP.put(CoinID.BITCOINSV_MAIN.getCoinType(), INFO_MARKETCAP_BITCOINSV);
        INFO_MARKETCAP.put(CoinID.BITCOINGOLD_MAIN.getCoinType(), INFO_MARKETCAP_BITCOINGOLD);
        INFO_MARKETCAP.put(CoinID.BITCOINONE_MAIN.getCoinType(), INFO_MARKETCAP_BITCOINONE);
        INFO_MARKETCAP.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), INFO_MARKETCAP_BITCOINTURBOKOIN);
        INFO_MARKETCAP.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), INFO_MARKETCAP_DOGECOINPRIVATE);
    }

    public static final CoinType DEFAULT_COIN = BitcoinMain.get();
    public static final List<CoinType> DEFAULT_COINS = ImmutableList.of((CoinType) BitcoinMain.get());

    public static final List<CoinType> SUPPORTED_COINS = ImmutableList.of(
            BitcoinMain.get(),
            LitecoinMain.get(),
            DogecoinMain.get(),
            DashMain.get(),
            PivxMain.get(),
        //    BitcoinCashMain.get(),
        //    BitcoinSvMain.get(),
        //    BitcoinGoldMain.get(),
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