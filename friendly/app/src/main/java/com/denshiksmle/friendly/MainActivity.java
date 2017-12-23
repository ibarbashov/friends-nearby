package com.denshiksmle.friendly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.denshiksmle.friendly.base.BaseActivity;
import com.denshiksmle.friendly.ui.login.LoginFragment;
import com.denshiksmle.friendly.ui.navigation.MainActivityNavigation;
import com.denshiksmle.friendly.ui.registration.RegistrationFragment;

public class MainActivity extends BaseActivity implements MainActivityNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toLoginScreen();
    }

    @Override
    public void toLoginScreen() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        final LoginFragment loginFragment = new LoginFragment();
        loginFragment.setNavigation(this);
        fragmentTransaction.replace(R.id.fragment_container, loginFragment, LoginFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        final Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (currentFragment instanceof LoginFragment) {
            this.finish();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void toRegistrationScreen() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        final RegistrationFragment registrationFragment = new RegistrationFragment();
        registrationFragment.setNavigation(this);
        fragmentTransaction.replace(R.id.fragment_container, registrationFragment, RegistrationFragment.TAG);
        fragmentTransaction.addToBackStack(LoginFragment.TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void toNavigationDrawerScreen() {

    }
}
