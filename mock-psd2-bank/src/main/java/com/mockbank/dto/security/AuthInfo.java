package com.mockbank.dto.security;

import one.util.streamex.StreamEx;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AuthInfo implements Authentication {

    private String principal;
    private String details;
    private Set<String> roles = new HashSet<>();

    public Set<String> getRoles() {
        return roles;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return StreamEx.of(roles).map(SimpleGrantedAuthority::new).toSet();
    }

    @Override
    public String getCredentials() {
        return null;
    }

    @Override
    public String getDetails() {
        return null;
    }

    @Override
    public String getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
