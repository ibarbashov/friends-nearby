package com.denshiksmle.friendly.ui.registration;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.base.BasePresenter;
import com.denshiksmle.friendly.base.BaseView;
import com.denshiksmle.friendly.model.entities.User;

/**
 * Created by denglob on 12/23/17.
 */

public class RegistrationScreenContract {

    public interface RegistrationPresenter extends BasePresenter {

        void registerUser(@NonNull final String email,
                          @NonNull final String password,
                          @NonNull final String userName);
    }

    public interface RegistrationView extends BaseView {
        void registrationComplete();

        void registrationError(@NonNull final String errorMessage);

        void registrationSuccess(@NonNull final User user);
    }
}
