package com.workshare.service;

import com.workshare.config.JwtService;
import com.workshare.model.Client;
import com.workshare.repository.ClientRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentiticationService {
    private final ClientRepository clientRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public String login(String username, String password) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                username,
                password
            )
        );

        Client client = clientRepository.findByUsername(username).orElse(null);
        return client != null ? jwtService.generateToken(client) : null;
    }

    public String signUp(@NotNull String username, @NotNull String password) {
        Client client = clientRepository.save(
            Client.builder()
                .password(passwordEncoder.encode(password))
                .username(username)
                .build()
        );

        return jwtService.generateToken(client);
    }
}