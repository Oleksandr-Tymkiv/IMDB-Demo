package com.project.main_module.dto;

import com.project.main_module.models.Author;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AlbumDTO(
        String nameAlbum,
        LocalDate releaseDate,
        Author author
) { }