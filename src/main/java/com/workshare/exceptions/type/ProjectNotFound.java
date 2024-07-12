package com.workshare.exceptions;

public class ProjectNotFound extends RuntimeException {
    public ProjectNotFound() {
        super("Project not found");
    }
}
