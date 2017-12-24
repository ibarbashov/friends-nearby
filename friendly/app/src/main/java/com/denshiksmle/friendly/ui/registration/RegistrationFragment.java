package com.denshiksmle.friendly.ui.registration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.denshiksmle.friendly.R;
import com.denshiksmle.friendly.app.FriendlyApp;
import com.denshiksmle.friendly.base.BaseFragment;
import com.denshiksmle.friendly.di.components.DaggerRegistrationScreenComponent;
import com.denshiksmle.friendly.di.modules.RegistrationScreenModule;
import com.denshiksmle.friendly.model.entities.User;
import com.denshiksmle.friendly.ui.navigation.MainActivityNavigation;

import javax.inject.Inject;

/**
 * Created by denglob on 12/23/17.
 */

public class RegistrationFragment extends BaseFragment implements RegistrationScreenContract.RegistrationView{

    public static final String TAG = "RegistrationFragment";

    protected EditText mUsername;
    protected EditText mEmail;
    protected EditText mPassword;
    protected Button mRegister;

    @Inject
    RegistrationScreenPresenter mRegistrationPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_register, container, false);

        mUsername = view.findViewById(R.id.usernameRegistration);
        mEmail = view.findViewById(R.id.emailRegistration);
        mPassword = view.findViewById(R.id.passwordRegistration);
        mRegister = view.findViewById(R.id.registerButton);

        DaggerRegistrationScreenComponent.builder()
                .netComponent(((FriendlyApp) getActivity().getApplicationContext()).getNetComponent())
                .registrationScreenModule(new RegistrationScreenModule(this))
                .build().inject(this);

        mRegister.setOnClickListener( l -> { showProgressDialog(getString(R.string.please_wait)); executeRegistration(); });

        return view;
    }

    private void executeRegistration () {
        if (validateFields(mUsername.getText().toString(), mUsername, getString(R.string.wrong_username_format)) &&
                validateFields(mEmail.getText().toString(), mEmail, getString(R.string.wrong_email)) &&
                validateFields(mPassword.getText().toString(), mPassword, getString(R.string.wrong_password))) {
            mRegistrationPresenter.registerUser(mEmail.getText().toString(), mPassword.getText().toString(),
                    mUsername.getText().toString());
        }
    }

    @Override
    public void registrationComplete() {
        Toast.makeText(getContext(), getString(R.string.registration_success_info), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registrationError(@NonNull String errorMessage) {
        hideProgressDialog();
        Toast.makeText(getContext(), getString(R.string.registration_fail), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registrationSuccess(@NonNull User user) {
        hideProgressDialog();
        if (user != null) {
            Toast.makeText(getContext(), getString(R.string.registration_success_info), Toast.LENGTH_SHORT).show();
            ((MainActivityNavigation) navigation).toNavigationDrawerScreen(user);
        }
        else {
            Toast.makeText(getContext(), getString(R.string.registration_fail), Toast.LENGTH_SHORT).show();
        }
    }
}
