package com.project.main_module.dto.mappers;

import com.project.main_module.dto.AlbumDTO;
import com.project.main_module.models.Album;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AlbumDTOMapper implements Function<Album, AlbumDTO> {
    @Override
    public AlbumDTO apply(Album album) {
        return AlbumDTO.builder()
                .nameAlbum(album.getNameAlbum())
                .author(album.getAuthor())
                .releaseDate(album.getReleaseDate())
                .build();
    }
}
