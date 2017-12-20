package com.denshiksmle.friendly.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.denshiksmle.friendly.di.components.DaggerFriendlyAppComponent;
import com.denshiksmle.friendly.di.components.FriendlyAppComponent;
import com.denshiksmle.friendly.di.modules.FriendlyAppModule;

/**
 * Created by denglob on 11/22/17.
 */

public class FriendlyApp extends Application {

    private FriendlyAppComponent friendlyAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraphAndInject();
    }

    public static FriendlyApp getApp(@NonNull final Context context) {
        return (FriendlyApp) context.getApplicationContext();
    }

    public FriendlyAppComponent getFriendlyAppComponent() {
        return friendlyAppComponent;
    }

    public void buildGraphAndInject() {
        friendlyAppComponent = DaggerFriendlyAppComponent.builder()
                .friendlyAppModule(new FriendlyAppModule(this))
                .build();
        friendlyAppComponent.inject(this);
    }
}
