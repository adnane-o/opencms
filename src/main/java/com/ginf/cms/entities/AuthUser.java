package com.ginf.cms.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Adnane on 10/02/2015.
 */
public class AuthUser extends User implements UserDetails {
    private org.springframework.security.core.userdetails.User user;

    public AuthUser(org.springframework.security.core.userdetails.User user) throws Exception {
        if (user == null)
            throw new Exception("Error in user adapter given security user is null");
        this.user = user;
    }

    @Override
    public Integer getId() {
        System.out.print("helo" + user.getUsername());
        return new Integer(user.getUsername());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
