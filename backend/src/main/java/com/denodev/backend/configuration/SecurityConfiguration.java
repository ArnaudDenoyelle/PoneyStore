package com.denodev.backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
        .formLogin();
  }
}
