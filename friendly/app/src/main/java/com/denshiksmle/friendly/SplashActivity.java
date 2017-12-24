package com.denshiksmle.friendly;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        int splashTimeOut = 2000;
        new Handler().postDelayed(() -> {
                Intent launchMain = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(launchMain);
                finish();
            }, splashTimeOut);
    }
}
