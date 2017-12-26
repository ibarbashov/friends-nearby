package com.denshiksmle.friendly.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.denshiksmle.friendly.di.components.DaggerNetComponent;
import com.denshiksmle.friendly.di.components.NetComponent;
import com.denshiksmle.friendly.di.modules.AppModule;
import com.denshiksmle.friendly.di.modules.NetModule;

/**
 * Created by denglob on 11/22/17.
 */

public class FriendlyApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://77.47.209.105:8080"))
                .build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
