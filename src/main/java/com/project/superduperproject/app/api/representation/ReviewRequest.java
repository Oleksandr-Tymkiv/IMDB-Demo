package com.project.superduperproject.app.api.representation;

import java.time.LocalDateTime;

public record ReviewRequest(
        String reviewText,
        LocalDateTime createdDate,
        Integer rating
) { }
