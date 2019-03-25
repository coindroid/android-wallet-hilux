package com.coinomi.wallet;

import android.text.format.DateUtils;

import com.coinomi.core.coins.HiluxMain;
import com.coinomi.core.coins.BitcoinMain;
import com.coinomi.core.coins.DashMain;
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

import static com.coinomi.wallet.ui.NavDrawerItemType.ITEM_LINK;
import static com.coinomi.wallet.ui.NavDrawerItemType.ITEM_SECTION_TITLE;

/**
 * @author John L. Jegutanis
 * @author Andreas Schildbach
 */
public class Constants {

    public static final boolean USE_FULL_TOP = true;

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

    /** Default currency to use if all default mechanisms fail. */
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

    public static final String VERSION_URL = "https://www.hilux.ioversion";
    public static final String PARTNERS_URI = "https://www.hilux.iopartner.json";
    public static final String SUPPORT_EMAIL = "hilux@gmail.com";

    // TODO move to resource files
    public static final List<CoinAddress> DEFAULT_COINS_SERVERS = ImmutableList.of(
            new CoinAddress(BitcoinMain.get(),      new ServerAddress("btc-cce-1.coinomi.net", 5001),
                    new ServerAddress("btc-cce-2.coinomi.net", 5001)),


            new CoinAddress(DashMain.get(),         new ServerAddress("drk-cce-1.coinomi.net", 5013),
                    new ServerAddress("drk-cce-2.coinomi.net", 5013)),

            new CoinAddress(HiluxMain.get(), new ServerAddress("node1.coindroid.org", 56011),
                    new ServerAddress("node1.coindroid.org", 56011))

    );

    public static final HashMap<CoinType, Integer> COINS_ICONS;
    public static final HashMap<CoinType, String> COINS_BLOCK_EXPLORERS;
    static {
        COINS_ICONS = new HashMap<>();
        COINS_ICONS.put(CoinID.HILUX_MAIN.getCoinType(), R.drawable.hilux);
        COINS_ICONS.put(CoinID.BITCOIN_MAIN.getCoinType(), R.drawable.bitcoin);
        COINS_ICONS.put(CoinID.DASH_MAIN.getCoinType(), R.drawable.dash);


        COINS_BLOCK_EXPLORERS = new HashMap<>();
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOIN_MAIN.getCoinType(), "https://blockchain.info/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DASH_MAIN.getCoinType(), "http://explorer.dashpay.io/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.HILUX_MAIN.getCoinType(), "http://explorer.hiluxcoin.com/tx/%s");
    }

    public static final CoinType DEFAULT_COIN = HiluxMain.get();
    public static final List<CoinType> DEFAULT_COINS = ImmutableList.of((CoinType) HiluxMain.get());

    public static final List<CoinType> SUPPORTED_COINS = ImmutableList.of(
            HiluxMain.get(),
            BitcoinMain.get(),
            DashMain.get()


    );

    public static void createNavDrawerItemsSecond(List<NavDrawerItem> navDrawerItemsSecond) {
        navDrawerItemsSecond.clear();
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_SECTION_TITLE, "Useful");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Bue & SELL", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
        NavDrawerItem.addItem(navDrawerItemsSecond, ITEM_LINK, "Any text", R.drawable.ic_launcher, "http://google.com");
    }
}