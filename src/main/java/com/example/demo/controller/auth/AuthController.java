// // package com.example.demo.controller;

// // import com.example.demo.config.JwtTokenProvider;
// // import com.example.demo.dto.AuthRequest;
// // import com.example.demo.dto.RegisterRequest;
// // import com.example.demo.entity.User;
// // import com.example.demo.service.UserService;
// // import lombok.RequiredArgsConstructor;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.HashMap;
// // import java.util.Map;

// // @RestController
// // @RequestMapping("/auth")
// // @RequiredArgsConstructor
// // public class AuthController {

// //     private final UserService userService;
// //     private final JwtTokenProvider jwtTokenProvider;
// //     private final BCryptPasswordEncoder passwordEncoder;

// //     @PostMapping("/register")
// //     public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

// //         User user = User.builder()
// //                 .name(request.getName())
// //                 .email(request.getEmail())
// //                 .password(request.getPassword())
// //                 .role("USER")
// //                 .build();

// //         User savedUser = userService.register(user);

// //         return ResponseEntity.ok(savedUser);
// //     }

// //     @PostMapping("/login")
// //     public ResponseEntity<?> login(@RequestBody AuthRequest request) {

// //         User user = userService.findByEmail(request.getEmail());

// //         if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
// //             return ResponseEntity.status(401).build();
// //         }

// //         String token = jwtTokenProvider.createToken(
// //                 user.getId(),
// //                 user.getEmail(),
// //                 user.getRole()
// //         );

// //         Map<String, String> response = new HashMap<>();
// //         response.put("token", token);

// //         return ResponseEntity.ok(response);
// //     }
// // }
// package com.example.demo.controller.auth;

// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;

//     public AuthController(UserService userService) {
//         this.userService = userService;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody RegisterRequest req) {

//         User user = new User();
//         user.setName(req.getName());
//         user.setEmail(req.getEmail());
//         user.setPassword(req.getPassword());
//         user.setRole("USER");

//         return ResponseEntity.ok(userService.save(user));
//     }
// }

package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).build();
        }
        String token = jwtTokenProvider.createToken(user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(AuthResponse.builder()
                .token(token)
                .userId(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build());
    }
}
