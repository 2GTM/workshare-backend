package com.workshare.exceptions.type;

public class ProjectNotFound extends RuntimeException {
    public ProjectNotFound() {
        super("Project not found");
    }
}
