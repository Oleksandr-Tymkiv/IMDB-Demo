package com.project.imdbdemo.app.api.representation.moviesRepresentation;

import java.time.LocalDate;

public record MovieRequest(
        String nameMovie,
        LocalDate releaseDate,
        String genre,
        String description) {
}

