package com.denshiksmle.friendly.ui.login;

import com.denshiksmle.friendly.base.BaseView;

/**
 * Created by denglob on 12/22/17.
 */

public interface LoginView extends BaseView{
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();
}
