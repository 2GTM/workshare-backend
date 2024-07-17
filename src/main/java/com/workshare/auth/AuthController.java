package com.workshare.auth;

import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/validate-token")
    public boolean validateToken(@RequestParam String token) {
        try {
            return authService.validateToken(token);
        } catch (JwtException e) {
            return false;
        }
    }
    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> signUp(
        @RequestParam String username,
        @RequestParam String password
    ) {
        return ResponseEntity.ok(new AuthResponse(authService.signUp(username, password)));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(new AuthResponse(authService.login(username, password)));
    }
}
