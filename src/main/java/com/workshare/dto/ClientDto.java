package com.workshare.dto;

import java.util.Set;

import com.workshare.model.Client;

public record ClientDto(String username, String bio, String github, String linkedin, Set<ProjectViewDto> projects) {
    public ClientDto(Client client, Set<ProjectViewDto> projects) {
        this(client.getUsername(), client.getBio(), client.getGithub(), client.getLinkedin(), projects);
    }
}