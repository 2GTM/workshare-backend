package com.workshare.dto;

import com.workshare.enums.LinkVisibility;
import com.workshare.model.Link;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record LinkDto(

    @Enumerated(EnumType.STRING)
    LinkVisibility visibility,

    String content
) {
    public static LinkDto from(Link link) {
        return new LinkDto(link.getVisibility(), link.getContent());
    }
}
