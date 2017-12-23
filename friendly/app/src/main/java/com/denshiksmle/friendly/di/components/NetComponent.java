package com.denshiksmle.friendly.di.components;

import com.denshiksmle.friendly.di.modules.AppModule;
import com.denshiksmle.friendly.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by denglob on 12/22/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();
}
