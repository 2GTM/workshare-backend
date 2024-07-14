package com.workshare.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final String[] WHITE_LIST_URL = {
        "/api/projects/search",
        "/api/projects/trend",
        "/api/auth"
    };

    private final JwtAuthentiticationFilter jwtAuthentiticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(
                authCustomizer -> authCustomizer
                    .requestMatchers(WHITE_LIST_URL).permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/projects/{projectId}").permitAll()
            )
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthentiticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
}
