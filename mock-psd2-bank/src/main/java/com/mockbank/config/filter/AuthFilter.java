package com.mockbank.config.filter;

import com.google.gson.Gson;
import com.mockbank.dto.security.AuthInfo;
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

    private static Gson GSON = new Gson();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        processEndpointAuthentication(httpServletRequest);
        chain.doFilter(request, response);
    }

    private void processEndpointAuthentication(HttpServletRequest request) {
        System.err.println(request.getHeader("X-Endpoint-API-UserInfo"));
        Optional.ofNullable(request.getHeader("X-Endpoint-API-UserInfo"))
                .map(encodedInfo -> {
                    System.err.println("Encode info: " + encodedInfo);
                    return new String(Base64.getDecoder().decode(encodedInfo));
                })
                .map(decodedInfo -> {
                    System.err.println("Decoded info: " + decodedInfo);
                    return GSON.fromJson(decodedInfo, AuthInfo.class);
                })
                .ifPresent(authInfo -> {
                    System.err.println("Auth info: " + authInfo);
                    SecurityContextHolder.getContext().setAuthentication(authInfo);
                });
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
