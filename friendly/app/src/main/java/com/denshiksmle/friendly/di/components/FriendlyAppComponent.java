package com.denshiksmle.friendly.di.components;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.app.FriendlyApp;
import com.denshiksmle.friendly.di.modules.FriendlyAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by denglob on 11/22/17.
 */
@Singleton
@Component(modules = { FriendlyAppModule.class })
public interface FriendlyAppComponent {
    void inject(@NonNull final FriendlyApp friendlyApp);
}
