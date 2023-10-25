package com.pressing.pressing.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

     String extractUserName(String username);

     String generateToken(UserDetails userDetails);
     boolean isTokenValid(String token, UserDetails userDetails);
}
