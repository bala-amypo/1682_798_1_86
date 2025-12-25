package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate user (simplified example)
        // In real app, you should use Spring Security authentication
        
        // Assuming authentication succeeded
        String token = jwtTokenProvider.createToken(
            1L, // userId - get this from authenticated user
            loginRequest.getUsername(),
            "USER" // role - get this from user entity
        );
        
        return ResponseEntity.ok(new AuthResponse(token));
    }
    
    // Inner classes for request/response
    static class LoginRequest {
        private String username;
        private String password;
        
        // getters and setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
    
    static class AuthResponse {
        private String token;
        
        public AuthResponse(String token) {
            this.token = token;
        }
        
        public String getToken() { return token; }
        public void setToken(String token) { this.token = token; }
    }
}