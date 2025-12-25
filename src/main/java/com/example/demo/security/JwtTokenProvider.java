package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // --------------- CONFIGURATION ---------------
    private final long jwtExpirationMs = 86400000; // 1 day

    // Load key from environment variable if possible, else use a generated one
    private final SecretKey secretKey;

    public JwtTokenProvider() {
        String base64Key = System.getenv("JWT_SECRET"); // set this in your environment
        if (base64Key != null && !base64Key.isEmpty()) {
            byte[] decodedKey = Base64.getDecoder().decode(base64Key);
            this.secretKey = Keys.hmacShaKeyFor(decodedKey);
        } else {
            // Generate a secure random key if env variable not set
            this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        }
    }

    // --------------- CREATE TOKEN ---------------
    public String createToken(Long userId, String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)   // store as Long
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    // --------------- GET CLAIMS ---------------
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // --------------- EXTRACT USERNAME ---------------
    public String getUsernameFromToken(String token) {
        return getClaims(token).getSubject();
    }

    // --------------- EXTRACT ROLE ---------------
    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }

    // --------------- EXTRACT USERID (SAFE) ---------------
    public Long getUserIdFromToken(String token) {
        Object userIdObj = getClaims(token).get("userId");
        if (userIdObj instanceof Integer) {
            return ((Integer) userIdObj).longValue();
        } else if (userIdObj instanceof Long) {
            return (Long) userIdObj;
        } else if (userIdObj instanceof String) {
            return Long.parseLong((String) userIdObj);
        } else {
            throw new RuntimeException("Invalid userId type in JWT");
        }
    }

    // --------------- VALIDATE TOKEN ---------------
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
