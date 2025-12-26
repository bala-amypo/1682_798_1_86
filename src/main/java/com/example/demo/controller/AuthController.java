package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.*;

import com.example.demo.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserService user;

    public AuthController(JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder,UserService user) {
    this.user=user;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody User us
    ) {
        
        // TODO: Save email, username, encodedPassword to DB
        user.register(us);
        return ResponseEntity.ok("User registered successfully");
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody(
                    description = "User login details",
                    required = true,
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"username\": \"string\",\n" +
                                            "  \"password\": \"string\"\n" +
                                            "}"
                            )
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody Map<String, String> request
    ) {
        String username = request.get("username");
        String password = request.get("password");

        // TODO: Validate username & password from DB
        Long userId = 1L;
        String role = "ADMIN";

        String token = jwtTokenProvider.createToken(userId, username, role);

        return ResponseEntity.ok(token);
    }
}
