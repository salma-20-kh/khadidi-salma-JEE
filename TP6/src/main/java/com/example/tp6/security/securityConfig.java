package com.example.tp6.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();
        String encodedPWD=passwordEncoder.encode("1234");
        //stocker en mémoire les utilisateurs qui ont acces à l'application
        auth.inMemoryAuthentication().withUser("user").password(encodedPWD).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("5678")).roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //damander à spring d'utiliser un formulaire d'authentification
        http.formLogin();
        // cette page ne nécessite pas une permission
        http.authorizeRequests().antMatchers("/").permitAll();
        //ces paths sont accessibles juste pour les utilisateurs qui ont role ADMIN
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        //ces paths sont accessibles juste pour les utilisateurs qui ont role USER
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER");
        //toute requete http nécessite une authentification
        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");

    }

    @Bean // au demarrage crée un objet de type PasswordEncoder
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
