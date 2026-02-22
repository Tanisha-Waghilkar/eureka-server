package com.student.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())   // disable CSRF for Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/eureka/**").permitAll()   // allow eureka
                        .anyRequest().authenticated()                // secure APIs
                )
                .httpBasic(Customizer.withDefaults());   // ✅ NEW syntax (IMPORTANT)

        return http.build();
    }
}