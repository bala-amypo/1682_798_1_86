package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
    
    @Value("${jwt.secret:myDefaultSecretKeyThatIsAtLeast256BitsLong1234567890ABCDEF}")
    private String jwtSecret;
    
    @Value("${jwt.expiration:86400000}")
    private long jwtExpirationMs;
    
    private Key key;
    
    @PostConstruct
    public void init() {
        // Ensure the secret is at least 256 bits (32 characters)
        if (jwtSecret.length() < 32) {
            // Pad or generate a secure key
            jwtSecret = padOrGenerateSecret(jwtSecret);
        }
        
        // Create a secure key
        byte[] keyBytes = Base64.getEncoder().encode(jwtSecret.getBytes());
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }
    
    private String padOrGenerateSecret(String secret) {
        if (secret.length() < 32) {
            // Pad the secret to make it 32 characters
            StringBuilder padded = new StringBuilder(secret);
            while (padded.length() < 32) {
                padded.append("0");
            }
            return padded.toString();
        }
        return secret;
    }
    
    public String createToken(Long userId, String username, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);
        
        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
    public String getRoleFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }
    
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}