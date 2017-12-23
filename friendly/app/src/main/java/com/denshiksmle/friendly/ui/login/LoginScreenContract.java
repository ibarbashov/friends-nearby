package com.denshiksmle.friendly.ui.login;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.base.BasePresenter;
import com.denshiksmle.friendly.base.BaseView;
import com.denshiksmle.friendly.model.entities.User;

/**
 * Created by denglob on 12/22/17.
 */

public interface LoginScreenContract {

    interface LoginView extends BaseView {

        void loginComplete();

        void loginError(@NonNull final String errorMessage);

        void loginSuccess(@NonNull final User user);
    }

    interface LoginPresenter extends BasePresenter {
        void loginUser(@NonNull final String email, @NonNull final String password);
    }
}
