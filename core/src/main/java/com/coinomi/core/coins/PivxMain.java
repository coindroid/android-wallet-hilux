package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PivxFamily;

/**
 * @author John L. Jegutanis
 */
public class PivxMain extends PivxFamily {
    private PivxMain() {
        id = "pivx.main"; // Do not change this id as wallets serialize this string

        addressHeader = 30;
        p2shHeader = 13;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 212;

        name = "PIVX";
        symbol = "PIVX";
        uriScheme = "pivx"; // TODO add multi uri, darkcoin
        bip44Index = 5;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 DASH mininput
        softDustLimit = value(100000); // 0.001 DASH
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Pivx Signed Message:\n");
    }

    private static PivxMain instance = new PivxMain();

    public static synchronized CoinType get() {
        return instance;
    }
}
