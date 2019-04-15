package com.coinomi.wallet.ui.info;

public enum InfoCoinType {
    BITCOIN("Bitcoin"),
    DASH("Dash"),
    BITCOIN_TURBO_COIN("Bitcoin Turbo Koin"),
    BITCOIN_ONE("BitCoin ONE"),
    DOGECOIN_PRIVATE("Dogecoin Private");

    private final String value;

    InfoCoinType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
