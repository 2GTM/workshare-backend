package com.workshare.service;

import com.workshare.exceptions.type.ClientNotFound;
import com.workshare.model.Client;
import com.workshare.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username)
                .orElseThrow(ClientNotFound::new);
    }

    public Set<String> getAllUsernames() {
        return clientRepository.findAllUsernames();
    }

    public int getProjectsNumber(String username) {
        return clientRepository.findProjectsNumber(username);
    }
}
