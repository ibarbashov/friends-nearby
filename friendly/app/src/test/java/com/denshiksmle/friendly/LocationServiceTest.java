package com.denshiksmle.friendly;

import com.denshiksmle.friendly.model.entities.Location;
import com.denshiksmle.friendly.model.entities.User;
import com.denshiksmle.friendly.model.exceptions.NoSuchUserException;
import com.denshiksmle.friendly.model.services.LocationService;
import com.denshiksmle.friendly.model.utils.HttpUtils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by denglob on 12/12/17.
 */

public class LocationServiceTest {

    @Test
    public void shouldReturnLocationByUser(){
        HttpUtils httpUtils = mock(HttpUtils.class);

        User user = new User("ootl8uuii6686misi", "Denys", "denGlob", "24088894yuo");
        Location userLocation = new Location(50.6658, 80.5590);
        when(httpUtils.getLastLocationOfUser(user.getUid())).thenReturn(userLocation);

        LocationService locationService = new LocationService(httpUtils);
        assertThat(locationService.formatLocationData("ootl8uuii6686misi"), is("50° 66' N, 80° 55' W"));
    }

    @Test(expected = NoSuchUserException.class)
    public void shouldReturnException(){
        HttpUtils httpUtils = mock(HttpUtils.class);

        Location location = null;
        when(httpUtils.getLastLocationOfUser("ootl8uuii6686misi")).thenReturn(location);

        LocationService locationService = new LocationService(httpUtils);
        assertThat(locationService.formatLocationData("ootl8uuii6686misi"), is("50° 66' N, 80° 55' W"));
    }
}
