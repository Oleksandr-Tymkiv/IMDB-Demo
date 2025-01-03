package com.project.superduperproject.app.dto;

import com.project.superduperproject.app.models.Movie;
import com.project.superduperproject.security.users.models.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReviewDTO(
        String reviewText,
        LocalDateTime createdDate,
        Integer rating,
        String movieName,
        String userName
){}
