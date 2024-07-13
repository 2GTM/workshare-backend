package com.workshare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record VoteProjectDto(

    @Positive
    long projectId,

    @NotBlank
    String username
) {
}
