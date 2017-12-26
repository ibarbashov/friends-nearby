package io.dudes.friendsnearby.service;

import io.dudes.friendsnearby.entity.User;
import io.dudes.friendsnearby.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
         return userRepository.findUserByUsername(username)
                 .orElseThrow(() -> new UsernameNotFoundException("You suck!"));
    }

    public User createUser(User newUser ) {
        String plainTextPass = newUser.getPassword();
        String encodedPass = passwordEncoder.encode(plainTextPass);
        return userRepository.save(newUser.withPassword(encodedPass));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public String capitalizeUserName(Long userId) {
//        return userRepository.findUserById(userId)
//                .map(User::getUsername)
//                .map(String::toUpperCase)
//                .orElseThrow(UserNotFoundException::new);
        return null;
    }
}
