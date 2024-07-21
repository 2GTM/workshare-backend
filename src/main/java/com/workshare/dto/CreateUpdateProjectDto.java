package com.workshare.dto;

import jakarta.validation.constraints.Size;
import java.util.Set;

public record CreateUpdateProjectDto(
    @Size(min = 5, max = 30) String title,

    @Size(min = 10, max = 50) String description,

    Set<String> membersUsername,
    Set<LinkDto> linksContent,
    Set<String> tagsContent
) {
}
