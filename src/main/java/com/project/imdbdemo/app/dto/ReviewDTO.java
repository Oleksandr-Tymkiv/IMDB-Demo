package com.project.imdbdemo.app.dto;

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
