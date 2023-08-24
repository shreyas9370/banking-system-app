package com.banking.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

 

@EnableWebSecurity

@Configuration

public class SecurityConfig {

    @Bean

    public PasswordEncoder passwordEncoderBean() {

        return new BCryptPasswordEncoder();

    }

    @Bean

    public UserDetailsService userDetailsService() {

        return new CustomUserDetails();

    }

 

    @Bean

    public JwtAuthFilter filter() {

        return new JwtAuthFilter();

    }

 

    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(authorizeHttpRequests->

                                authorizeHttpRequests

                                        .requestMatchers("/swagger-ui/**").permitAll()

                                        .requestMatchers("/v3/api-docs/**").permitAll()

                                        .requestMatchers("/auth/login").permitAll()

                                        .requestMatchers("/api/**").authenticated()

                                        .requestMatchers("/users/register").permitAll()

//                                .requestMatchers("/api/*").permitAll()

                ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

        .addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class)

                .build();

    }

 

    @Bean

    public AuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userDetailsService());

        daoAuthenticationProvider.setPasswordEncoder(passwordEncoderBean());

        return daoAuthenticationProvider;

    }

 

    @Bean

    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {

        return builder.getAuthenticationManager();

    }

}