package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author main@m42.cx
 */
public class DogecoinprivateMain extends BitFamily {
    private DogecoinprivateMain() {
        id = "dogecoinprivate.main"; // Do not change this id as wallets serialize this string



        addressHeader = 30;
        p2shHeader = 13;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 158;

        name = "DogecoinPrivate";
        symbol = "DOGP";
        uriScheme = "dogecoinprivate";
        bip44Index = 0;
        unitExponent = 8;
        feeValue = value(500000);
        minNonDust = value(1000); // 0.00001 DASH mininput
        softDustLimit = value(5000); // 0.001 DASH
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Dogecoinprivate Signed Message:\n");

    }

    private static DogecoinprivateMain instance = new DogecoinprivateMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
