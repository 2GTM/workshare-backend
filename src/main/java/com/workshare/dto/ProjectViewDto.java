package com.workshare.dto;

import com.workshare.model.Client;
import com.workshare.model.Link;
import com.workshare.model.Project;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
public record ProjectViewDto(
    @Size(min = 5, max = 30)
    String title,

    @Size(min = 10, max = 50)
    String description,

    // The votes number is not taking in consideration when creating or updating a post.
    @Positive
    Integer votes,

    @NotNull
    String publisherName,

    @NotNull
    Set<String> membersUsername,

    @NotNull
    Set<String> linksContent
) {
    public static ProjectViewDto from(Project project) {
        return new ProjectViewDto(
            project.getTitle(),
            project.getDescription(),
            project.getVotes(),
            project.getClient().getUsername(),
            project.getMembers().stream().map(Client::getUsername).collect(Collectors.toSet()),
            project.getLinks().stream().map(Link::getContent).collect(Collectors.toSet())
        );
    }
}
