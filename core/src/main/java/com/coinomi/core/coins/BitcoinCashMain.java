package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

public class BitcoinCashMain extends BitFamily {
    private BitcoinCashMain() {
        id = "btccash.main";

        addressHeader = 0;
        p2shHeader = 5;
        acceptableAddressCodes = new int[]{addressHeader, p2shHeader};
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "BitcoinCash";
        symbol = "BCH";
        uriScheme = "bitcoincash";
        addressPrefix = "bitcoincash";
        bip44Index = 145;
        unitExponent = 8;
        feeValue = value(10000);

        minNonDust = value(1000); // 0.00001 DASH mininput
        softDustLimit = value(5000); // 0.001 DASH
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("BitcoinCash Signed Message:\n");
    }

    private static BitcoinCashMain instance = new BitcoinCashMain();

    public static synchronized CoinType get() {
        return instance;
    }
}
