package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

public class BitcoinSvMain extends BitFamily {
    private BitcoinSvMain() {
        id = "bitcoinsv.main";

        addressHeader = 0;
        p2shHeader = 5;
        acceptableAddressCodes = new int[]{addressHeader, p2shHeader};
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;
        name = "BitcoinSV";
        symbol = "BSV";
        uriScheme = "bitcoincash";
        addressPrefix = "bitcoinsv";
        bip44Index = 236;
        unitExponent = 8;
        feeValue = value(10000);

        minNonDust = value(1000); // 0.00001 DASH mininput
        softDustLimit = value(5000); // 0.001 DASH
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("BitcoinSv Signed Message:\n");
    }

    private static BitcoinSvMain instance = new BitcoinSvMain();

    public static synchronized CoinType get() {
        return instance;
    }
}
