package com.example.tp8.security;

import com.example.tp8.security.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //damander à spring d'utiliser un formulaire d'authentification
        http.formLogin();
        // cette page ne nécessite pas une permission
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();

        //ces paths sont accessibles juste pour les utilisateurs qui ont role ADMIN
        //http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");

        //ces paths sont accessibles juste pour les utilisateurs qui ont role USER
        //http.authorizeRequests().antMatchers("/user/**").hasRole("USER");
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("USER");

        //toute requete http nécessite une authentification
        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");

    }

}
