package com.project.superduperproject.music.dto;

import com.project.superduperproject.music.models.Author;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AlbumDTO(
        String nameAlbum,
        LocalDate releaseDate,
        Author author
) { }