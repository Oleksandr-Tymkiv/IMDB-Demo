package com.project.main_module.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record AuthorDTO(
        String authorName,
        String bio,
        String genre
) { }
