package com.project.main_module.api.representation;

import lombok.Data;

import java.time.LocalDate;

public record AlbumRequest(
        String nameAlbum,
        LocalDate releaseDate,
        Long authorId) {
}