package com.denshiksmle.friendly.model.services;

import com.denshiksmle.friendly.model.entities.User;
import com.denshiksmle.friendly.model.exceptions.NoSuchUserException;
import com.denshiksmle.friendly.model.utils.HttpUtils;

/**
 * Created by troll on 11.12.2017.
 */

public class UserService {

    private HttpUtils httpUtils;

    public UserService(HttpUtils httpUtils) {
        this.httpUtils = httpUtils;
    }

    public String addATSignToUsername(String email){
        User user = httpUtils.getUserFromServerByUserEmail(email);
        if (user != null){
            return "@"+user.getName();
        }
        throw new NoSuchUserException();
    }
}
