package com.workshare.dto;

import com.workshare.model.Client;
import com.workshare.model.Project;

public record VoteProjectDto(

        long projectId,
        long clientId
) { }
