package com.project.superduperproject.music.api.representation;

import lombok.Data;

import java.time.LocalDate;

public record AlbumRequest(
        String nameAlbum,
        LocalDate releaseDate,
        Long authorId) {
}