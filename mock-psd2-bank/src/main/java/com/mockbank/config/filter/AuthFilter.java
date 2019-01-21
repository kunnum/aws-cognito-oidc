package com.mockbank.config.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Component
public class AuthFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        processEndpointAuthentication(httpServletRequest);
        chain.doFilter(request, response);
    }

    private void processEndpointAuthentication(HttpServletRequest request) {
        /*Optional.ofNullable(request.getHeader("X-Endpoint-API-UserInfo"))
                .map(encodedInfo -> new String(Base64.getDecoder().decode(encodedInfo)))
                .map(info -> GSON.fromJson(info, HashMap.class))
                .map(map -> String.valueOf(map.get("claims")))
                .map(claims -> GSON.fromJson(claims, AuthDTO.class))
                .filter(auth -> ALLOWED_DOMAIN_TOKEN.equals(auth.getDomain()))
                .ifPresent(authDTO -> {
                    authDTO.setGroups(googleGroupsService.getGoogleGroupsForUser(authDTO.getEmail()));
                    SecurityContextHolder.getContext().setAuthentication(authDTO);
                });*/
        // TODO Process token
        SecurityContextHolder.getContext().setAuthentication(new DummyAuthentication());
    }

    private class DummyAuthentication implements Authentication {

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority("PSD2"));
        }

        @Override
        public Object getCredentials() {
            return null;
        }

        @Override
        public Object getDetails() {
            return "meeraj";
        }

        @Override
        public Object getPrincipal() {
            return "meeraj";
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
            return "meeraj";
        }
    }


}
