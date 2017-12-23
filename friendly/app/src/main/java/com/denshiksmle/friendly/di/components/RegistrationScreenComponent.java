package com.denshiksmle.friendly.di.components;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.di.modules.RegistrationScreenModule;
import com.denshiksmle.friendly.di.util.RegistrationScope;
import com.denshiksmle.friendly.ui.registration.RegistrationFragment;

import dagger.Component;

/**
 * Created by denglob on 12/23/17.
 */

@RegistrationScope
@Component(dependencies = NetComponent.class, modules = RegistrationScreenModule.class)
public interface RegistrationScreenComponent {
    void inject(@NonNull final RegistrationFragment registrationFragment);
}
