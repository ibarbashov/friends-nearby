package io.dudes.friendsnearby.service;

import io.dudes.friendsnearby.entity.User;
import io.dudes.friendsnearby.exception.UserNotFoundException;
import io.dudes.friendsnearby.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Test
    public void shouldCapitalizeUsername() {
        UserRepository userRepositoryMock = mock(UserRepository.class);
        PasswordEncoder passwordEncoderMock = mock(PasswordEncoder.class);

        when(userRepositoryMock.findUserById(42L))
                .thenReturn(Optional.of(new User("jdoe", "passwd", "John Doe")));

        UserService userService = new UserServiceImpl(userRepositoryMock, passwordEncoderMock);

        assertThat(userService.capitalizeUserName(42L))
                .isEqualTo("JDOE");
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowUserNotFoundException() {
        UserRepository userRepositoryMock = mock(UserRepository.class);
        PasswordEncoder passwordEncoderMock = mock(PasswordEncoder.class);

        when(userRepositoryMock.findUserById(42L))
                .thenReturn(Optional.empty());

        UserService userService = new UserServiceImpl(userRepositoryMock, passwordEncoderMock);
        userService.capitalizeUserName(42L);
    }
}
