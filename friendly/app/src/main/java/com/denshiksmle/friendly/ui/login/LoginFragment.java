package com.denshiksmle.friendly.ui.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.denshiksmle.friendly.R;
import com.denshiksmle.friendly.app.FriendlyApp;
import com.denshiksmle.friendly.base.BaseFragment;
import com.denshiksmle.friendly.di.components.DaggerLoginScreenComponent;
import com.denshiksmle.friendly.di.modules.LoginScreenModule;
import com.denshiksmle.friendly.model.entities.User;

import javax.inject.Inject;

/**
 * Created by denglob on 12/22/17.
 */

public class LoginFragment extends BaseFragment implements LoginScreenContract.LoginView {

    protected EditText loginField;
    protected EditText passwordField;
    protected Button login;
    protected TextView registration;

    @Inject
    LoginScreenPresenter loginScreenPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginField = view.findViewById(R.id.loginEmail);
        passwordField = view.findViewById(R.id.loginPassword);
        registration = view.findViewById(R.id.goToRegistrationTextView);
        login = view.findViewById(R.id.loginButton);

        DaggerLoginScreenComponent.builder()
                .netComponent(((FriendlyApp) getActivity().getApplicationContext()).getNetComponent())
                .loginScreenModule(new LoginScreenModule(this))
                .build().inject(this);
        return view;
    }

    @Override
    public void loginComplete() {

    }

    @Override
    public void loginError(@NonNull String errorMessage) {

    }

    @Override
    public void loginSuccess(@NonNull User user) {

    }
}
