package com.denodev.backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Arnaud DENOYELLE
 *
 *         Le 06 nov. 2016
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("ram").password("ram123").roles("ADMIN");
    auth.inMemoryAuthentication().withUser("ravan").password("ravan123").roles("USER");
    auth.inMemoryAuthentication().withUser("kans").password("kans123").roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .anyRequest()
        .permitAll()
    .and()
        .exceptionHandling()
            .accessDeniedHandler(accessDeniedHandler())
            .authenticationEntryPoint(authenticationEntryPoint());
  }

  private AccessDeniedHandler accessDeniedHandler() {
    return (httpServletRequest, httpServletResponse, e) -> {
      httpServletResponse.setStatus(403);
      httpServletResponse.getWriter().append("Access denied");
    };
  }

  private AuthenticationEntryPoint authenticationEntryPoint() {
    return (httpServletRequest, httpServletResponse, e) -> {
      httpServletResponse.setStatus(403);
      httpServletResponse.getWriter().append("Authentication entrypoint");
    };
  }
}
