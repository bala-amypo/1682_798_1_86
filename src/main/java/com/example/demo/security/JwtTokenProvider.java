package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String JWT_SECRET = "mySecretKey"; // move to env later
    private final long JWT_EXPIRATION = 24 * 60 * 60 * 1000; // 1 day

    // ✅ CREATE TOKEN (used in AuthController)
    public String createToken(Long userId, String username, String role) {

        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }

    // ✅ Extract username (used in JwtAuthenticationFilter)
    public String getUsernameFromToken(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // ✅ Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
