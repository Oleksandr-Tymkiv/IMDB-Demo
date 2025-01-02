package com.project.main_module.dto.mappers;

import com.project.main_module.dto.AuthorDTO;
import com.project.main_module.models.Author;
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
