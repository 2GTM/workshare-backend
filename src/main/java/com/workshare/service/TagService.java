package com.workshare.service;

import com.workshare.model.Tag;
import com.workshare.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Set<Tag> getTagsFromListOfStrings(Set<String> tags) {
        return tags.stream()
            .map(
                tag -> tagRepository.findOneByContent(tag).orElse(tagRepository.save(new Tag(tag)))
            )
            .collect(Collectors.toSet());
    }
}
