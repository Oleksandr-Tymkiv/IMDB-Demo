package com.project.superduperproject.music.dto;

import com.project.superduperproject.music.models.Album;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

@Builder
public record MusicDTO(
        String title,
        Album album
){}
