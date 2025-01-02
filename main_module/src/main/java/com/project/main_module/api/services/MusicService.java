package com.project.main_module.api.services;

import com.project.main_module.api.representation.MusicRequest;
import com.project.main_module.dto.MusicDTO;
import com.project.main_module.dto.mappers.MusicDTOMapper;
import com.project.main_module.models.Album;
import com.project.main_module.models.Author;
import com.project.main_module.models.Music;
import com.project.main_module.repository.AlbumRepository;
import com.project.main_module.repository.MusicRepository;
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
