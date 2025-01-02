package com.project.superduperproject.music.api.services;

import com.project.superduperproject.music.api.representation.MusicRequest;
import com.project.superduperproject.music.dto.MusicDTO;
import com.project.superduperproject.music.dto.mappers.MusicDTOMapper;
import com.project.superduperproject.music.models.Album;
import com.project.superduperproject.music.models.Author;
import com.project.superduperproject.music.models.Music;
import com.project.superduperproject.music.repository.AlbumRepository;
import com.project.superduperproject.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;
    private final AlbumRepository albumRepository;
    private final MusicDTOMapper musicDTOMapper;

    public void saveMusic (MusicRequest musicRequest) {
        Album album = albumRepository.findById(musicRequest.albumId())
                .orElseThrow(()-> new IllegalStateException("Album not found"));
        musicRepository.save(Music.builder()
                        .title(musicRequest.title())
                        .album(album)
                .build());
    }

    public List<MusicDTO> getAllMusics() {
        return musicRepository
                .findAll()
                .stream()
                .map(musicDTOMapper)
                .toList();
    }
}
