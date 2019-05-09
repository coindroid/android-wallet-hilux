package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author John L. Jegutanis
 *
 * Still used in tests
 */
public class RavencoinMain extends BitFamily {
    private RavencoinMain() {
        id = "ravencoin.main";

        addressHeader = 60;
        p2shHeader = 122;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Ravencoin";
        symbol = "RVN";
        uriScheme = "ravencoin";
        bip44Index = 0;
        unitExponent = 8;
        feeValue = value(12000);
        minNonDust = value(5460);
        softDustLimit = value(1000000); // 0.01 BTC
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("Bitcoin Signed Message:\n");
    }

    private static RavencoinMain instance = new RavencoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
