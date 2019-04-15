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

    public static final HashMap<CoinType, Integer> COINS_ICONS;
    public static final HashMap<CoinType, String> COINS_BLOCK_EXPLORERS;

    public static final HashMap<CoinType, HashMap<String, String>> INFO_EXCHANGES;
    public static final HashMap<String, String> INFO_EXCHANGES_DOGECOINPRIVATE;
    public static final HashMap<String, String> INFO_EXCHANGES_BITCOINTURBOKOIN;
    public static final HashMap<String, String> INFO_EXCHANGES_BITCOINONE;
    public static final HashMap<String, String> INFO_EXCHANGES_BITCOIN;
    public static final HashMap<String, String> INFO_EXCHANGES_DASH;

    public static final HashMap<CoinType, HashMap<String, String>> INFO_SOCIAL;
    public static final HashMap<String, String> INFO_SOCIAL_DOGECOINPRIVATE;
    public static final HashMap<String, String> INFO_SOCIAL_BITCOINTURBOKOIN;
    public static final HashMap<String, String> INFO_SOCIAL_BITCOINONE;
    public static final HashMap<String, String> INFO_SOCIAL_BITCOIN;
    public static final HashMap<String, String> INFO_SOCIAL_DASH;

    public static final HashMap<CoinType, String> INFO_DESCRIBE;

    static {
        COINS_ICONS = new HashMap<>();
        COINS_ICONS.put(CoinID.BITCOINONE_MAIN.getCoinType(), R.drawable.bitcoinone);
        COINS_ICONS.put(CoinID.BITCOIN_MAIN.getCoinType(), R.drawable.bitcoin);
        COINS_ICONS.put(CoinID.DASH_MAIN.getCoinType(), R.drawable.dash);
        COINS_ICONS.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), R.drawable.dogecoinprivate);
        COINS_ICONS.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), R.drawable.bitcointurbokoin);

        COINS_BLOCK_EXPLORERS = new HashMap<>();
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOIN_MAIN.getCoinType(), "https://blockchain.info/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DASH_MAIN.getCoinType(), "http://explorer.dashpay.io/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINONE_MAIN.getCoinType(), "http://explorer.bitcoinone.io/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), "http://explorer.dogecoinprivate.dog/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), "http://explorer.bitcointurbokoin.com/tx/%s");

        //------------------------------------Info-Describe-----------------------------------------
        INFO_DESCRIBE = new HashMap<>();
        INFO_DESCRIBE.put(CoinID.BITCOIN_MAIN.getCoinType(), "BITCOIN");
        INFO_DESCRIBE.put(CoinID.DASH_MAIN.getCoinType(), "DASH");
        INFO_DESCRIBE.put(CoinID.BITCOINONE_MAIN.getCoinType(), "BITCOINONE");
        INFO_DESCRIBE.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), "BITCOINTURBOKOIN");
        INFO_DESCRIBE.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), "DOGECOINPRIVATE");


        //------------------------------------Info-Exchanges----------------------------------------
        INFO_EXCHANGES_BITCOIN = new HashMap<>();
        INFO_EXCHANGES_BITCOIN.put("CREX24_2", "https://www.google.com/");
        INFO_EXCHANGES_BITCOIN.put("BITFINEX", "https://www.google.com/");
        INFO_EXCHANGES_BITCOIN.put("HITBTC", "https://www.google.com/");
        INFO_EXCHANGES_BITCOIN.put("SUTHEXCAHNGE", "https://www.google.com/");

        INFO_EXCHANGES_BITCOINONE = new HashMap<>();
        INFO_EXCHANGES_BITCOINONE.put("CREX24_2", "https://www.google.com/");
        INFO_EXCHANGES_BITCOINONE.put("BITFINEX_2", "https://www.google.com/");
        INFO_EXCHANGES_BITCOINONE.put("HITBTC_2", "https://www.google.com/");
        INFO_EXCHANGES_BITCOINONE.put("SUTHEXCAHNGE_2", "https://www.google.com/");

        INFO_EXCHANGES_DASH = new HashMap<>();
        INFO_EXCHANGES_DASH.put("CREX24_2", "https://www.google.com/");
        INFO_EXCHANGES_DASH.put("BITFINEX_2", "https://www.google.com/");
        INFO_EXCHANGES_DASH.put("HITBTC_2", "https://www.google.com/");
        INFO_EXCHANGES_DASH.put("SUTHEXCAHNGE_2", "https://www.google.com/");

        INFO_EXCHANGES_BITCOINTURBOKOIN = new HashMap<>();
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("CREX24_2", "https://www.google.com/");
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("BITFINEX_2", "https://www.google.com/");
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("HITBTC_2", "https://www.google.com/");
        INFO_EXCHANGES_BITCOINTURBOKOIN.put("SUTHEXCAHNGE_2", "https://www.google.com/");

        INFO_EXCHANGES_DOGECOINPRIVATE = new HashMap<>();
        INFO_EXCHANGES_DOGECOINPRIVATE.put("CREX24_2", "https://www.google.com/");
        INFO_EXCHANGES_DOGECOINPRIVATE.put("BITFINEX_2", "https://www.google.com/");
        INFO_EXCHANGES_DOGECOINPRIVATE .put("HITBTC_2", "https://www.google.com/");
        INFO_EXCHANGES_DOGECOINPRIVATE .put("SUTHEXCAHNGE_2", "https://www.google.com/");

        INFO_EXCHANGES = new HashMap<>();
        INFO_EXCHANGES.put(CoinID.BITCOIN_MAIN.getCoinType(), INFO_EXCHANGES_BITCOIN);
        INFO_EXCHANGES.put(CoinID.DASH_MAIN.getCoinType(), INFO_EXCHANGES_DASH);
        INFO_EXCHANGES.put(CoinID.BITCOINONE_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINONE);
        INFO_EXCHANGES.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), INFO_EXCHANGES_BITCOINTURBOKOIN);
        INFO_EXCHANGES.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), INFO_EXCHANGES_DOGECOINPRIVATE);

        //------------------------------------Info-Social-------------------------------------------
        INFO_SOCIAL_BITCOIN = new HashMap<>();
        INFO_SOCIAL_BITCOIN.put("www.bitcoin.com", "https://www.google.com/");
        INFO_SOCIAL_BITCOIN.put("t.me/bitcoin", "https://www.google.com/");
        INFO_SOCIAL_BITCOIN.put("Discord.com/PPR3", "https://www.google.com/");
        INFO_SOCIAL_BITCOIN.put("Email@support.com", "https://www.google.com/");

        INFO_SOCIAL_BITCOINONE = new HashMap<>();
        INFO_SOCIAL_BITCOINONE.put("www.bitcoin.com", "https://www.google.com/");
        INFO_SOCIAL_BITCOINONE.put("t.me/bitcoin", "https://www.google.com/");
        INFO_SOCIAL_BITCOINONE.put("Discord.com/PPR3", "https://www.google.com/");
        INFO_SOCIAL_BITCOINONE.put("Email@support.com", "https://www.google.com/");

        INFO_SOCIAL_DASH = new HashMap<>();
        INFO_SOCIAL_DASH.put("www.bitcoin.com", "https://www.google.com/");
        INFO_SOCIAL_DASH.put("t.me/bitcoin", "https://www.google.com/");
        INFO_SOCIAL_DASH.put("Discord.com/PPR3", "https://www.google.com/");
        INFO_SOCIAL_DASH.put("Email@support.com", "https://www.google.com/");

        INFO_SOCIAL_BITCOINTURBOKOIN = new HashMap<>();
        INFO_SOCIAL_BITCOINTURBOKOIN.put("www.bitcoin.com", "https://www.google.com/");
        INFO_SOCIAL_BITCOINTURBOKOIN.put("t.me/bitcoin", "https://www.google.com/");
        INFO_SOCIAL_BITCOINTURBOKOIN.put("Discord.com/PPR3", "https://www.google.com/");
        INFO_SOCIAL_BITCOINTURBOKOIN.put("Email@support.com", "https://www.google.com/");

        INFO_SOCIAL_DOGECOINPRIVATE = new HashMap<>();
        INFO_SOCIAL_DOGECOINPRIVATE.put("www.bitcoin.com", "https://www.google.com/");
        INFO_SOCIAL_DOGECOINPRIVATE.put("t.me/bitcoin", "https://www.google.com/");
        INFO_SOCIAL_DOGECOINPRIVATE .put("Discord.com/PPR3", "https://www.google.com/");
        INFO_SOCIAL_DOGECOINPRIVATE .put("Email@support.com", "https://www.google.com/");

        INFO_SOCIAL = new HashMap<>();
        INFO_SOCIAL.put(CoinID.BITCOIN_MAIN.getCoinType(), INFO_SOCIAL_BITCOIN);
        INFO_SOCIAL.put(CoinID.DASH_MAIN.getCoinType(), INFO_SOCIAL_DASH);
        INFO_SOCIAL.put(CoinID.BITCOINONE_MAIN.getCoinType(), INFO_SOCIAL_BITCOINONE);
        INFO_SOCIAL.put(CoinID.BITCOINTURBOKOIN_MAIN.getCoinType(), INFO_SOCIAL_BITCOINTURBOKOIN);
        INFO_SOCIAL.put(CoinID.DOGECOINPRIVATE_MAIN.getCoinType(), INFO_SOCIAL_DOGECOINPRIVATE);
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