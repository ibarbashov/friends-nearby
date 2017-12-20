package com.denshiksmle.friendly.di.modules;

import android.app.Application;
import android.support.annotation.NonNull;

import com.denshiksmle.friendly.app.FriendlyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denglob on 11/22/17.
 */

@Module
public class FriendlyAppModule {

    private final FriendlyApp friendlyApp;

    public FriendlyAppModule(@NonNull final FriendlyApp friendlyApp) {
        this.friendlyApp = friendlyApp;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return friendlyApp;
    }
}
