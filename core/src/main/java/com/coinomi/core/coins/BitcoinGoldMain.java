package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

public class BitcoinGoldMain extends BitFamily {
    private BitcoinGoldMain() {
        id = "btcgold.main";

        addressHeader = 38;
        p2shHeader = 23;
        acceptableAddressCodes = new int[]{addressHeader, p2shHeader};
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "BitcoinGold";
        symbol = "BTG";
        uriScheme = "bitcoingold";
        addressPrefix = "btg";
        bip44Index = 156;
        unitExponent = 8;
        feeValue = value(100000);

        minNonDust = value(1000); // 0.00001 DASH mininput
        softDustLimit = value(5000); // 0.001 DASH
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("BitcoinGold Signed Message:\n");
    }

    private static BitcoinGoldMain instance = new BitcoinGoldMain();

    public static synchronized CoinType get() {
        return instance;
    }
}
