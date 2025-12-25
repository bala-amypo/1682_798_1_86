package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {
    
    @Value("${app.jwt.secret}")
    private String jwtSecret = "yourSecretKeyShouldBeLongAndSecureForProduction";
    
    @Value("${app.jwt.expiration}")
    private int jwtExpirationInMs = 86400000; // 24 hours
    
    public String createToken(Long userId, String email, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    
    public Claims validateToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex) {
            throw new RuntimeException("Invalid JWT token");
        }
    }
    
    public String getEmail(String token) {
        Claims claims = validateToken(token);
        return claims.getSubject();
    }
    
    public Long getUserId(String token) {
        Claims claims = validateToken(token);
        return claims.get("userId", Long.class);
    }
    
    public String getRole(String token) {
        Claims claims = validateToken(token);
        return claims.get("role", String.class);
    }
}