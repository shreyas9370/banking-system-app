package com.banking.security;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

 

@Data

@NoArgsConstructor

@AllArgsConstructor

public class JwtRequest {

    String email;

    String password;

}