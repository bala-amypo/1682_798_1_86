package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String role = request.get("role"); // USER or ADMIN

        // Encode password (you should save this to DB)
        String encodedPassword = passwordEncoder.encode(password);

        // TODO: Save username, encodedPassword, and role to DB

        return ResponseEntity.ok("User registered successfully");
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        // TODO: Validate username & password against DB
        // For demo, assume userId = 1 and role = ADMIN
        Long userId = 1L;
        String role = "ADMIN";

        // Create JWT token
        String token = jwtTokenProvider.createToken(userId, username, role);

        return ResponseEntity.ok(token);
    }
}
