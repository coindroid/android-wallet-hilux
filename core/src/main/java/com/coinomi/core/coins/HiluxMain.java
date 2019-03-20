package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author main@m42.cx
 */
public class HiluxMain extends BitFamily {
    private HiluxMain() {
        id = "hilux.main"; // Do not change this id as wallets serialize this string



        addressHeader = 40;
        p2shHeader = 18;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 168;

        name = "Hilux";
        symbol = "HLX";
        uriScheme = "hilux";
        bip44Index = 0;
        unitExponent = 8;
        feeValue = value(500000);
        minNonDust = value(1000); // 0.00001 DASH mininput
        softDustLimit = value(5000); // 0.001 DASH
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Hilux Signed Message:\n");

    }

    private static HiluxMain instance = new HiluxMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
