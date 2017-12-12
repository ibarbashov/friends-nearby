package com.denshiksmle.friendly;

import com.denshiksmle.friendly.model.entities.User;
import com.denshiksmle.friendly.model.exceptions.NoSuchUserException;
import com.denshiksmle.friendly.model.services.UserService;
import com.denshiksmle.friendly.model.utils.HttpUtils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by troll on 10.12.2017.
 */
public class UserServiceTest {

    @Test
    public void shouldReturnModifiedName(){
        HttpUtils httpUtils = mock(HttpUtils.class);

        User user = new User("Dima", "Dimagio_bond", "8800555353pozvonit");
        when(httpUtils.getUserFromServerByUserEmail("example@gmail.com")).thenReturn(user);

        UserService userService = new UserService(httpUtils);
        assertThat(userService.addATSignToUsername("example@gmail.com"), is("@Dimagio_bond"));
    }

    @Test(expected = NoSuchUserException.class)
    public void shouldReturnException(){
        HttpUtils httpUtils = mock(HttpUtils.class);

        User user = null;
        when(httpUtils.getUserFromServerByUserEmail("example@gmail.com")).thenReturn(user);

        UserService userService = new UserService(httpUtils);
        assertThat(userService.addATSignToUsername("example@gmail.com"), is("@Dimagio_bond"));
    }
}
