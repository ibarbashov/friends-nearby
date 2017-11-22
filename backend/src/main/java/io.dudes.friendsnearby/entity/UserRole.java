package io.dudes.friendsnearby.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    REGULAR_USER;

    @Override
    public String getAuthority() {
        return REGULAR_USER.name();
    }
}
