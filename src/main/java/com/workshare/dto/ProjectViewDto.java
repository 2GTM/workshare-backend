package com.workshare.dto;

import com.workshare.model.Client;
import com.workshare.model.Project;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.Set;

@Builder
public record ProjectViewDto(
        @Size(min = 5, max = 30)
        String title,

        @Size(min = 10, max = 50)
        String description,

        @NotNull
        String nameOfPublisher,

        @NotNull
        Set<String> membersUsername
) {
    public static ProjectViewDto from(Project project) {
        return ProjectViewDto
                .builder()
                    .title(project.getTitle())
                    .description(project.getDescription())
                    .nameOfPublisher(project.getPublisher().getUsername())
                .build();
    }
}
