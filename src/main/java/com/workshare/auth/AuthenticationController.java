package com.workshare.auth;

import com.workshare.service.AuthentiticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthentiticationService authentiticationService;

    public AuthenticationController(AuthentiticationService authentiticationService) {
        this.authentiticationService = authentiticationService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(
        @RequestParam String username,
        @RequestParam String password
    ) {
        return ResponseEntity.ok(authentiticationService.signUp(username, password));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(authentiticationService.login(username, password));
    }
}
