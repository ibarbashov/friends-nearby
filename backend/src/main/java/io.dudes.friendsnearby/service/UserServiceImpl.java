package io.dudes.friendsnearby.service;

import io.dudes.friendsnearby.entity.User;
import io.dudes.friendsnearby.exception.UserNotFoundException;
import io.dudes.friendsnearby.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(UserNotFoundException::new);
    }

    public User createUser(User newUser ) {
        return userRepository.save(newUser);
    }

    @Override
    public String capitalizeUserName(Long userId) {
        return null;
    }
}
