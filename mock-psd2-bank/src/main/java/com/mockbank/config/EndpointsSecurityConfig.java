package com.mockbank.config;


import com.mockbank.config.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class EndpointsSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthFilter authFilter;

    /**
     *
     * @param authFilter
     */
    @Autowired
    public EndpointsSecurityConfig(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests().anyRequest().authenticated().and()
            .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**").and()
            .ignoring().antMatchers("/swagger-resources/**").and()
            .ignoring().antMatchers("/v2/api-docs").and()
            .ignoring().antMatchers("/swagger-ui.html").and()
            .ignoring().antMatchers(HttpMethod.OPTIONS);
    }
}
