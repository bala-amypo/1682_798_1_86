// // package com.example.demo.service.impl;

// // import com.example.demo.entity.User;
// // import com.example.demo.exception.BadRequestException;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.UserService;
// // import lombok.RequiredArgsConstructor;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.stereotype.Service;

// // @Service
// // @RequiredArgsConstructor
// // public class UserServiceImpl implements UserService {

// //     private final UserRepository userRepository;
// //     private final BCryptPasswordEncoder passwordEncoder;

// //     @Override
// //     public User register(User user) {
// //         if (userRepository.findByEmail(user.getEmail()).isPresent()) {
// //             throw new BadRequestException("Email");
// //         }
// //         user.setPassword(passwordEncoder.encode(user.getPassword()));
// //         return userRepository.save(user);
// //     }

// //     @Override
// //     public User findByEmail(String email) {
// //         return userRepository.findByEmail(email).orElse(null);
// //     }

// //     @Override
// //     public User findById(Long id) {
// //         return userRepository.findById(id)
// //                 .orElseThrow(() -> new BadRequestException("User"));
// //     }
// // }


// package com.example.demo.service.impl;

// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// @Service
// @RequiredArgsConstructor
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;

//     @Override
//     public User register(RegisterRequest request) {
//         User user = User.builder()
//                 .name(request.getName())
//                 .email(request.getEmail())
//                 .password(request.getPassword()) // plain text (no security)
//                 .role("FARMER")
//                 .build();
//         return userRepository.save(user);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
