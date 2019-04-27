package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author main@m42.cx
 */
public class BitcoinoneMain extends BitFamily {
    private BitcoinoneMain() {
        id = "bitcoinone.main"; // Do not change this id as wallets serialize this string



        addressHeader = 85;
        p2shHeader = 13;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 213;

        name = "BitCoin ONE";
        symbol = "BTCONE";
        uriScheme = "bitcoinone";
        bip44Index = 5;
        unitExponent = 8;

        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 DASH mininput
        softDustLimit = value(5000); // 0.001 DASH
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Bitcoinone Signed Message:\n");

    }

    private static BitcoinoneMain instance = new BitcoinoneMain();

    public static synchronized CoinType get() {
        return instance;
    }
}
