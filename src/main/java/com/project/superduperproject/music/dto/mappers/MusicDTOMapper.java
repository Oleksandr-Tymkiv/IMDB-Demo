package com.project.superduperproject.music.dto.mappers;

import com.project.superduperproject.music.dto.MusicDTO;
import com.project.superduperproject.music.models.Music;
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
