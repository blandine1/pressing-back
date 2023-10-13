package com.pressing.pressing.config;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

  /*  private static final String SECRET ="phfjlagunsjrkvrtebkuamazhzcwgofbphfjlagunsjrkvrtebkuamazhzcwgofb";

    public String extractUserName(String token) {
        return  extractClaim(token, Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims= extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return  generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignINKeys(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenValid(token);
    }

    private boolean isTokenValid(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return  extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignINKeys())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignINKeys() {
        byte[] keyByte = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyByte);
    }*/
}
