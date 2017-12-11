package com.denshiksmle.friendly.model.utils;

import com.denshiksmle.friendly.model.entities.User;

/**
 * Created by troll on 10.12.2017.
 */

public interface HttpUtils {

    User getUserFromServerByUserEmail(String email);
}
