package com.workshare.controller;

import com.workshare.dto.ClientDto;
import com.workshare.model.Client;
import com.workshare.service.ClientService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.codec.ClientCodecConfigurer.ClientDefaultCodecs;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/usernames")
    public Set<String> getAllUsernames() {
        return clientService.getAllUsernames();
    }

    @GetMapping("/{username}")
    public ClientDto getUserInfo(@PathVariable String username) {
        return new ClientDto(clientService.getClientByUsername(username), clientService.getProjectsNumber(username));
    }
}
