package com.denshiksmle.friendly.ui.registration;

import android.support.annotation.NonNull;

import com.denshiksmle.friendly.model.entities.User;
import com.denshiksmle.friendly.util.ExponentialBackoff;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by denglob on 12/23/17.
 */

public class RegistrationScreenPresenter implements RegistrationScreenContract.RegistrationPresenter {

    Retrofit retrofit;
    RegistrationScreenContract.RegistrationView mRegistrationView;

    @Inject
    public RegistrationScreenPresenter(@NonNull final Retrofit retrofit,
                                       @NonNull final RegistrationScreenContract.RegistrationView mRegistrationView) {
        this.retrofit = retrofit;
        this.mRegistrationView = mRegistrationView;
    }

    @Override
    public void registerUser(@NonNull String email, @NonNull String password, @NonNull String userName) {
        retrofit.create(UserService.class).getUser(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .retryWhen(ExponentialBackoff.exponentialBackoffForExceptions(3, 2, TimeUnit.SECONDS, Exception.class))
                .subscribe(user -> mRegistrationView.registrationSuccess(user),
                        error -> mRegistrationView.registrationError(error.getMessage()));
    }

    private interface UserService {
        @POST("/authentication/{email}/{password}")
        Observable<User> getUser(@Path("email") String email,
                                 @Path("password") String password);
    }
}
