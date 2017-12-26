package com.denshiksmle.friendly.di.modules;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.di.util.LoginScope;
import com.denshiksmle.friendly.ui.login.LoginScreenContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denglob on 12/23/17.
 */

@Module
public class LoginScreenModule {

    private final LoginScreenContract.LoginView mView;

    public LoginScreenModule(@NonNull final LoginScreenContract.LoginView mView) {
        this.mView = mView;
    }

    @Provides
    @LoginScope
    LoginScreenContract.LoginView providesLoginScreenContractView() {
        return mView;
    }
}
