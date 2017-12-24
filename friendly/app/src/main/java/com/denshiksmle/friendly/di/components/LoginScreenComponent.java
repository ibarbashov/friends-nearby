package com.denshiksmle.friendly.di.components;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.di.modules.LoginScreenModule;
import com.denshiksmle.friendly.di.util.LoginScope;
import com.denshiksmle.friendly.ui.login.LoginFragment;

import dagger.Component;

/**
 * Created by denglob on 12/23/17.
 */

@LoginScope
@Component(dependencies = NetComponent.class, modules = LoginScreenModule.class)
public interface LoginScreenComponent {
    void inject(@NonNull final LoginFragment loginFragment);
}
