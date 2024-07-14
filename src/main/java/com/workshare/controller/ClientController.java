package com.workshare.controller;

import com.workshare.dto.ClientDto;
import com.workshare.dto.ProjectViewDto;
import com.workshare.model.Client;
import com.workshare.service.ClientService;
import com.workshare.service.ProjectService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ProjectService projectService;

    @GetMapping("/usernames")
    public Set<String> getAllUsernames() {
        return clientService.getAllUsernames();
    }

    @GetMapping("/{username}")
    public ClientDto getUserInfo(@PathVariable String username) {
        Client client = clientService.getClientByUsername(username);
        if (client != null) {
            Set<ProjectViewDto> projects = projectService.getAllProjects(client);
            return new ClientDto(client, projects);
        } else {
            return null;
        }
    }
}