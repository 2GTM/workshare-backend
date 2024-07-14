package com.workshare.exceptions.type;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException() {
        super("Tagà not found");
    }
}
