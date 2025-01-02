package com.project.main_module.api.services;

import com.project.main_module.api.representation.AlbumRequest;
import com.project.main_module.dto.AlbumDTO;
import com.project.main_module.dto.mappers.AlbumDTOMapper;
import com.project.main_module.models.Album;
import com.project.main_module.models.Author;
import com.project.main_module.repository.AlbumRepository;
import com.project.main_module.repository.AuthorRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final AuthorRepository authorRepository;
    private final AlbumDTOMapper albumDTOMapper;

    public void saveAlbum(AlbumRequest albumRequest) {
        Author author = authorRepository.findById(albumRequest.authorId())
                .orElseThrow(()-> new IllegalStateException("Author not found"));
        albumRepository.save(Album.builder()
                        .nameAlbum(albumRequest.nameAlbum())
                        .releaseDate(albumRequest.releaseDate())
                        .author(author)
                .build());
    }

    public List<AlbumDTO> getAllAlbums() {
        return albumRepository
                .findAll()
                .stream()
                .map(albumDTOMapper)
                .toList();
    }
}
