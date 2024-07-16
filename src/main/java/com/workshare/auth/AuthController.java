package com.workshare.auth;

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
        return authService.validateToken(token);
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
