package com.project.imdbdemo.app.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record MovieDTO(
        String nameMovie,
        LocalDate releaseDate,
        String genre,
        String description
) { }

