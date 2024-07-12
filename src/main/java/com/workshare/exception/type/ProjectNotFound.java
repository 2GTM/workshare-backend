package com.workshare.exception.type;

public class ProjectNotFound extends RuntimeException {
    public ProjectNotFound() {
        super("Project not found");
    }
}
