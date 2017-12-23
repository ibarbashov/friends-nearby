package com.denshiksmle.friendly.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.EditText;

import com.denshiksmle.friendly.ui.navigation.BaseNavigation;

/**
 * Created by denglob on 11/22/17.
 */

public class BaseFragment extends Fragment {

    protected BaseNavigation navigation;

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
