package com.workshare.controller;

import com.workshare.service.AuthentiticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("${ALLOWED_URL}")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthentiticationService authentiticationService;

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

    @PostMapping("/testing")
    public String test() {
        return "fdasafdsfdas";
    }
}
