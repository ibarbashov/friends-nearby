package com.denshiksmle.friendly.di.modules;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denglob on 11/22/17.
 */

@Module
public class AppModule {

    Application app;

    public AppModule(@NonNull final Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }
}
