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
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        // TODO: Implement user registration logic
        // 1. Check if user already exists
        // 2. Save new user to database
        // 3. Generate JWT token
        // 4. Return token or success message
        
        // For now, just return a success message
        String message = "User registration endpoint. Implement registration logic here.";
        return ResponseEntity.ok(new RegisterResponse(
            "User registered successfully",
            1L, // userId
            registerRequest.getEmail(),
            "USER"
        ));
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
    
    static class RegisterRequest {
        private String email;
        private String username;
        private String password;
        
        // getters and setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
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
    
    static class RegisterResponse {
        private String message;
        private Long userId;
        private String email;
        private String role;
        
        public RegisterResponse(String message, Long userId, String email, String role) {
            this.message = message;
            this.userId = userId;
            this.email = email;
            this.role = role;
        }
        
        // getters and setters
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
    }
}