package com.workshare.exceptions;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound() {
        super("Client not found");
    }
}
