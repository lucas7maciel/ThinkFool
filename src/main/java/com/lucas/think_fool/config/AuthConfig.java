package com.lucas.think_fool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lucas.think_fool.config.auth.SecurityFilter;

@Configuration
@EnableWebSecurity
public class AuthConfig {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        // Auth
                        .requestMatchers(HttpMethod.POST, "/auth/*").permitAll()
                        // Thinker
                        .requestMatchers(HttpMethod.GET, "/thinker").permitAll()
                        .requestMatchers(HttpMethod.POST, "/thinker").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/thinker").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/thinker").hasRole("ADMIN")
                        // Post
                        .requestMatchers(HttpMethod.GET, "/post").permitAll()
                        .requestMatchers(HttpMethod.POST, "/post").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/post").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/post").authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
