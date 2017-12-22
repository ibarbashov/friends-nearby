package com.denshiksmle.friendly.di.components;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.app.FriendlyApp;
import com.denshiksmle.friendly.di.modules.FriendlyAppModule;
import com.denshiksmle.friendly.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by denglob on 12/22/17.
 */

@Singleton
@Component(modules = {FriendlyAppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();
}
