package com.mockbank.dto.security;

import lombok.Builder;
import lombok.Data;
import one.util.streamex.StreamEx;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;

/**
 *
 */
@Data
@Builder
public class AuthInfo implements Authentication {

    private String name;
    private boolean authenticated;
    private String principal;
    private String details;
    private Set<String> roles;
    private String credentials;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return StreamEx.of(roles).map(SimpleGrantedAuthority::new).toSet();
    }

}
