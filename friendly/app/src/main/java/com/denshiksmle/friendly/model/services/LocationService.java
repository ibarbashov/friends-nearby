package com.denshiksmle.friendly.model.services;

import com.denshiksmle.friendly.model.entities.Location;
import com.denshiksmle.friendly.model.exceptions.NoSuchUserException;
import com.denshiksmle.friendly.model.utils.HttpUtils;

/**
 * Created by denglob on 12/12/17.
 */

public class LocationService {

    private final String LOCATION_FORMAT = "%s° %s' N, %s° %s' W";
    private HttpUtils httpUtils;

    public LocationService(HttpUtils httpUtils) {
        this.httpUtils = httpUtils;
    }

    public String formatLocationData(String userId) {
        final Location location = httpUtils.getLastLocationOfUser(userId);
        if (location != null) {
            final String strLatitude = String.valueOf(location.getLatitude()).substring(0, 5);
            final String strLongitude = String.valueOf(location.getLongitude()).substring(0, 5);
            final String[] latitudeValues = strLatitude.split("\\.");
            final String[] longitudesValues = strLongitude.split("\\.");
            return String.format(LOCATION_FORMAT, latitudeValues[0], latitudeValues[1],
                    longitudesValues[0], longitudesValues[1]);
        }
        else {
            throw new NoSuchUserException();
        }
    }
}
