package com.mockbank.config.filter;

import com.google.gson.Gson;
import com.mockbank.dto.security.AuthInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

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
        Optional.ofNullable(request.getHeader("X-Endpoint-API-UserInfo"))
                .map(encodedInfo -> new String(Base64.getDecoder().decode(encodedInfo)))
                .map(decodedInfo ->  GSON.fromJson(decodedInfo, AuthInfo.class))
                .ifPresent(authInfo -> SecurityContextHolder.getContext().setAuthentication(authInfo));
    }

}
