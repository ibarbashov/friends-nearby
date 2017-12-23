package com.denshiksmle.friendly.ui.login;

import android.accounts.NetworkErrorException;
import android.support.annotation.NonNull;

import com.denshiksmle.friendly.model.entities.User;
import com.denshiksmle.friendly.util.ExponentialBackoff;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by denglob on 12/22/17.
 */

public class LoginScreenPresenter implements LoginScreenContract.LoginPresenter {
    Retrofit retrofit;
    LoginScreenContract.LoginView mView;

    @Inject
    public LoginScreenPresenter(@NonNull final Retrofit retrofit,
                                @NonNull final LoginScreenContract.LoginView mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loginUser(@NonNull final String email, @NonNull final String password) {
        retrofit.create(UserService.class).getUser(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .retryWhen(
                        ExponentialBackoff.exponentialBackoffForExceptions(3, 2, TimeUnit.SECONDS, Exception.class))
                .subscribe(
                        user -> mView.loginSuccess(user) ,
                        error -> mView.loginError(error.getMessage())
                );
    }

    private interface UserService {
        @GET("/authentication/{email}/{password}")
        Observable<User> getUser(@Path("email") String email,
                                 @Path("password") String password);
    }
}
