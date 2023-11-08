package com.pressing.pressing.services.impl;

import com.pressing.pressing.services.JWTService;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//@Service
//implements JWTService
public class JWTServiceImpl  {

    /*public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey(){
        byte[] bytes = Decoders.BASE64.decode("aeyHn9V227J7XAvIgtunjJnjxjkKKFwqBjZjqX5wd8SyBWgaBYan4ffyuf7tyfhuytRDDYGGIUgfg");
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

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    public String generateRreshToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 604800000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private boolean isTokenExpired(String token) {
        return extractClain(token, Claims::getExpiration).before(new Date());
    }*/
}