package com.coinomi.wallet.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.coinomi.wallet.ui.BaseWalletActivity;
import com.coinomi.wallet.ui.WalletActivity;

public class SplashScreen extends BaseWalletActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, WalletActivity.class);
        startActivity(intent);
        finish();
    }
}
