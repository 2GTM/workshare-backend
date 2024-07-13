package com.workshare.dto;

import com.workshare.enums.LinkVisibility;
import com.workshare.model.Link;

public record LinkDto(
    LinkVisibility visibility,
    String content
) {
    public static LinkDto from(Link link) {
        return new LinkDto(link.getVisibility(), link.getContent());
    }
}
