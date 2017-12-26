package io.dudes.friendsnearby.service;

import io.dudes.friendsnearby.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    String capitalizeUserName(Long userId);

    User createUser(User user);

    List<User> findAll();
}
