package com.workshare.dto;

import com.workshare.model.Client;

public record ClientDto(String username, String bio, String github, int projectsCount) {
    public ClientDto(Client client, int projectsCount) {
        this(client.getUsername(), client.getBio(), client.getGithub(), projectsCount);
    }   
}