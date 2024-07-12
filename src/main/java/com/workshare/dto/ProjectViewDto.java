package com.workshare.dto;

import com.workshare.model.Project;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import java.util.Set;

@Builder
public record ProjectViewDto(
        Long id,

        @Size(min = 5, max = 30)
        String title,

        @Size(min = 10, max = 50)
        String description,

        @Positive
        int votes,

        @NotNull
        String publisherName,

        @NotNull
        Set<String> memberUsernames
) {
    public static ProjectViewDto from(Project project) {
        return ProjectViewDto
                .builder()
                    .title(project.getTitle())
                    .description(project.getDescription())
                    .votes(project.getVotes())
                    .publisherName(project.getClient().getUsername())
                .build();
    }
}
