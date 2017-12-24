package com.denshiksmle.friendly.ui.navigation;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.model.entities.User;

/**
 * Created by denglob on 12/23/17.
 */

public interface MainActivityNavigation extends BaseNavigation {

    void toLoginScreen();
    void toRegistrationScreen();
    void toNavigationDrawerScreen(@NonNull final User user);
}
