package com.workshare.exceptions.type;

public class MembersNotFound extends RuntimeException {
    public MembersNotFound() {
        super("Project not found");
    }
}
