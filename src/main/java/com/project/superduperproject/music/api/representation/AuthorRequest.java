package com.project.superduperproject.music.api.representation;

public record AuthorRequest(
        String authorName,
        String bio,
        String genre
) { }
