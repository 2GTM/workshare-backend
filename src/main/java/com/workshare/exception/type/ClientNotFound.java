package com.workshare.exception.type;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound() {
        super("Client not found");
    }
}
