package io.dudes.friendsnearby.service;

import io.dudes.friendsnearby.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    String capitalizeUserName(Long userId);

    User createUser(User user);
}
