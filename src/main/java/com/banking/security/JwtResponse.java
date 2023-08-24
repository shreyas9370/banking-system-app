package com.banking.security;

import lombok.AllArgsConstructor;

import lombok.Builder;

import lombok.Data;

import lombok.NoArgsConstructor;

 

@Builder

@Data

@NoArgsConstructor

@AllArgsConstructor

public class JwtResponse {

    String jwtToken;

    String username;

}