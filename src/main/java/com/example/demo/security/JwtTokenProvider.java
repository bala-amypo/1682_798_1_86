package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final SecretKey secretKey;
    
    public JwtTokenProvider(@Value("${app.jwt.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }
    
    // Method with 3 parameters (as AuthController expects)
    public String createToken(Long userId, String username, String role) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 86400000); // 24 hours
        
        return Jwts.builder()
                .subject(username)
                .claim("userId", userId)
                .claim("role", role)
                .issuedAt(now)
                .expiration(validity)
                .signWith(secretKey)
                .compact();
    }
    
    // Optional: Method with 1 parameter (if you need it)
    public String createToken(String username) {
        return createToken(null, username, null);
    }
    
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }
    
    public Long getUserId(String token) {
        return getClaims(token).get("userId", Long.class);
    }
    
    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }
    
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}