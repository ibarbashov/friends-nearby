package com.denshiksmle.friendly.di.modules;

import com.denshiksmle.friendly.di.util.RegistrationScope;
import com.denshiksmle.friendly.ui.registration.RegistrationScreenContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denglob on 12/23/17.
 */

@Module
public class RegistrationScreenModule {

    private final RegistrationScreenContract.RegistrationView mRegistrationView;

    public RegistrationScreenModule(RegistrationScreenContract.RegistrationView mRegistrationView) {
        this.mRegistrationView = mRegistrationView;
    }

    @Provides
    @RegistrationScope
    RegistrationScreenContract.RegistrationView providesRegistrationScreenContractView() {
        return mRegistrationView;
    }
}
