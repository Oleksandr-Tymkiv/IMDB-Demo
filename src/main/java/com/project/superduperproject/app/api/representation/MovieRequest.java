package com.project.superduperproject.app.api.representation;

import java.time.LocalDate;

public record MovieRequest(
        String nameMovie,
        LocalDate releaseDate,
        String genre,
        String description) {
}

