package com.denshiksmle.friendly.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.denshiksmle.friendly.di.components.FriendlyAppComponent;
import com.denshiksmle.friendly.di.components.NetComponent;
import com.denshiksmle.friendly.di.modules.FriendlyAppModule;
import com.denshiksmle.friendly.di.modules.NetModule;

/**
 * Created by denglob on 11/22/17.
 */

public class FriendlyApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraphAndInject();
    }

    public static FriendlyApp getApp(@NonNull final Context context) {
        return (FriendlyApp) context.getApplicationContext();
    }

    public NetComponent getmNetComponent() {
        return mNetComponent;
    }

    public void buildGraphAndInject() {

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new FriendlyAppModule(this))
                .netModule(new NetModule("http://iodudes.com/"))
                .build();
    }
}
