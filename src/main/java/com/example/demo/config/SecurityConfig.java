package com.example.demo.config; 
import com.example.demo.security.JwtAuthenticationFilter; 
import com.example.demo.security.JwtTokenProvider; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.web.SecurityFilterChain; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; 
 
@Configuration 
public class SecurityConfig { 
 
    private final JwtTokenProvider jwtTokenProvider; 
 
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) { 
        this.jwtTokenProvider = jwtTokenProvider; 
    } 
 @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/auth/**",
                "/swagger-ui/**",
                "/v3/api-docs/**",
                "/catalog/**"   // 👈 ADD THIS
            ).permitAll()
            .anyRequest().authenticated()
        )
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
