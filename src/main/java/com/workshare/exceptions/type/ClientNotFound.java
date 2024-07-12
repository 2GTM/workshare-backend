package com.workshare.exceptions.type;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound() {
        super("Client not found");
    }
}
