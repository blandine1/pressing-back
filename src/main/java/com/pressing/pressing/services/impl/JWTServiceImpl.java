package com.pressing.pressing.services.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceImpl {

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey(){
        byte[] bytes = Decoders.BASE64.decode("aeyHn9V227+%J7XAv@I@gtunj$J(njxjkKKFwqBjZjqX5wd8SyBWgaBY@an4");
        return Keys.hmacShaKeyFor(bytes);
    }

    private <T> T extractClain(String token, Function<Claims, T> clainResolver){
         final Claims claims = extractAllClaims(token);
         return clainResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
      return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }

    public String extractUserName(String token){
        return extractClain(token, Claims::getSubject);
    }

    private boolean isTokenValid(String token, UserDetails userDetails){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClain(token, Claims::getExpiration).before(new Date());
    }
}