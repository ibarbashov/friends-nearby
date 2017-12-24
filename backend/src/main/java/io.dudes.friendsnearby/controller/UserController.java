package io.dudes.friendsnearby.controller;

import io.dudes.friendsnearby.entity.User;
import io.dudes.friendsnearby.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userServiceImpl;

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        return new ResponseEntity<>(userServiceImpl.createUser(user), HttpStatus.CREATED);
    }
}
