package com.workshare.service;

import com.workshare.exceptions.type.ClientNotFound;
import com.workshare.model.Client;
import com.workshare.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username)
                .orElseThrow(ClientNotFound::new);
    }
}
