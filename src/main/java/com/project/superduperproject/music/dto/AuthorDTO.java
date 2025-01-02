package com.project.superduperproject.music.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record AuthorDTO(
        String authorName,
        String bio,
        String genre
) { }
