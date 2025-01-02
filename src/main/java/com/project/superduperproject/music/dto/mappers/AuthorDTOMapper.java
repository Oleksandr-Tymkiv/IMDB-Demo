package com.project.superduperproject.music.dto.mappers;

import com.project.superduperproject.music.dto.AuthorDTO;
import com.project.superduperproject.music.models.Author;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AuthorDTOMapper implements Function<Author, AuthorDTO> {
    @Override
    public AuthorDTO apply(Author author) {
        return AuthorDTO.builder()
                .authorName(author.getAuthorName())
                .bio(author.getBio())
                .genre(author.getGenre())
                .build();
    }
}
