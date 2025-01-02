package com.project.main_module.dto.mappers;

import com.project.main_module.dto.MusicDTO;
import com.project.main_module.models.Music;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MusicDTOMapper implements Function<Music, MusicDTO> {
    @Override
    public MusicDTO apply(Music music) {
        return MusicDTO.builder()
                .title(music.getTitle())
                .album(music.getAlbum())
                .build();
    }
}
