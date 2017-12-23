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
import android.widget.Toast;

import com.denshiksmle.friendly.R;
import com.denshiksmle.friendly.app.FriendlyApp;
import com.denshiksmle.friendly.base.BaseFragment;
import com.denshiksmle.friendly.di.components.DaggerLoginScreenComponent;
import com.denshiksmle.friendly.di.modules.LoginScreenModule;
import com.denshiksmle.friendly.model.entities.User;
import com.denshiksmle.friendly.ui.navigation.MainActivityNavigation;

import javax.inject.Inject;

/**
 * Created by denglob on 12/22/17.
 */

public class LoginFragment extends BaseFragment implements LoginScreenContract.LoginView {

    public static final String TAG = "LoginFragment";

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

        login.setOnClickListener( l -> {
            showProgressDialog(getString(R.string.please_wait));
            executeLogin();
        });
        registration.setOnClickListener( l -> ((MainActivityNavigation) navigation).toRegistrationScreen());
        return view;
    }

    //This must be in interactor
    private void executeLogin() {
        if (validateFields(loginField.getText().toString(), loginField, getString(R.string.wrong_email)) &&
                validateFields(passwordField.getText().toString(), passwordField, getString(R.string.wrong_password))) {
            loginScreenPresenter.loginUser(loginField.getText().toString(), passwordField.getText().toString());
        }
    }

    @Override
    public void loginComplete() {
        hideProgressDialog();
        Toast.makeText(getContext(), getString(R.string.login_success_info), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError(@NonNull String errorMessage) {
        hideProgressDialog();
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(@NonNull User user) {
        hideProgressDialog();
        ((MainActivityNavigation)navigation).toNavigationDrawerScreen();
    }
}
