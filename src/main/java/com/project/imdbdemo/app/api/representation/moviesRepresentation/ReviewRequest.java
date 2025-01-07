package com.project.imdbdemo.app.api.representation.moviesRepresentation;

import java.time.LocalDateTime;

public record ReviewRequest(
        String reviewText,
        LocalDateTime createdDate,
        Integer rating
) { }
