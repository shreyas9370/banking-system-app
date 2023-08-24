package com.banking.security;

import com.banking.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

 

@Service

public class CustomUserDetails implements UserDetailsService {

 

    @Autowired
    UserRepo userInfoRepository;

 

    @Bean

    public PasswordEncoder passwordEncoder() {

        return  new BCryptPasswordEncoder();

    }

 

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userInfoRepository.findByUserName(username).get();


    }

 

 

}