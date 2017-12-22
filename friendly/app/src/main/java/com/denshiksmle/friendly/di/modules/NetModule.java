package com.denshiksmle.friendly.di.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.denshiksmle.friendly.app.FriendlyApp;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by denglob on 12/22/17.
 */

@Module
public class NetModule {
    final String mBaseUrl;

    public NetModule(@NonNull final String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(@NonNull final FriendlyApp friendlyApp) {
        return PreferenceManager.getDefaultSharedPreferences(friendlyApp);
    }

    @Provides
    @Singleton
    public Cache provideHttpCache(@NonNull final FriendlyApp friendlyApp) {
        int cacheSize = 10 * 1024 * 1024;
        final Cache cache = new Cache(friendlyApp.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(@NonNull final Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache);
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@NonNull final OkHttpClient okHttpClient, @NonNull final Gson gson) {
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

}
