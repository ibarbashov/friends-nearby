package com.denshiksmle.friendly.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.denshiksmle.friendly.ui.navigation.BaseNavigation;

/**
 * Created by denglob on 11/22/17.
 */

public class BaseFragment extends Fragment {

    protected BaseNavigation navigation;

    protected ProgressDialog progressDialog;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        progressDialog = new ProgressDialog(getContext());
        super.onViewCreated(view, savedInstanceState);
    }

    public void showProgressDialog(@NonNull final String message) {
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void hideProgressDialog() {
        if (isVisible()) {
            progressDialog.dismiss();
        }
    }

    public void setNavigation(@NonNull final BaseNavigation navigation) {
        this.navigation = navigation;
    }

    protected boolean validateFields(@NonNull final String checkedParam,
                                     @NonNull final EditText viewField,
                                     @NonNull final String errorString) {
        if (TextUtils.isEmpty(checkedParam)) {
            viewField.setError(errorString);
            return false;
        }
        return true;
    }
}
