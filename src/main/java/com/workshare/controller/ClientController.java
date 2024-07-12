package com.workshare.controller;

import com.workshare.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@CrossOrigin("${ALLOWED_URL}")
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/usernames")
    public Set<String> getAllUsernames() {
        return clientService.getAllUsernames();
    }
}
