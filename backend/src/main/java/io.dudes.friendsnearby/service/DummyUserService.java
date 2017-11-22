package io.dudes.friendsnearby.service;

import io.dudes.friendsnearby.entity.User;
import io.dudes.friendsnearby.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DummyUserService implements UserService {
    private final UserRepository userRepository;

    @Override
    public String capitalizeUserName(Long userId) {
        return userRepository.findUserById(userId)
                .map(User::getUsername)
                .map(String::toUpperCase)
                .orElseThrow(UserNotFoundException::new);
    }
}
