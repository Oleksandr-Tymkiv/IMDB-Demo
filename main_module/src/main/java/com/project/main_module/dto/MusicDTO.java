package com.project.main_module.dto;

import com.project.main_module.models.Album;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

@Builder
public record MusicDTO(
        String title,
        Album album
){}
