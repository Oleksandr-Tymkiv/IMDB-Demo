package com.project.superduperproject.music.api.services;

import com.project.superduperproject.music.api.representation.AuthorRequest;
import com.project.superduperproject.music.dto.AlbumDTO;
import com.project.superduperproject.music.dto.AuthorDTO;
import com.project.superduperproject.music.dto.mappers.AuthorDTOMapper;
import com.project.superduperproject.music.models.Author;
import com.project.superduperproject.music.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorDTOMapper authorDTOMapper;

    public void saveAuthor(AuthorRequest authorRequest) {
        authorRepository.save(Author.builder()
                        .authorName(authorRequest.authorName())
                        .bio(authorRequest.bio())
                        .genre(authorRequest.genre())
                .build());
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository
                .findAll()
                .stream()
                .map(authorDTOMapper)
                .toList();
    }
}
