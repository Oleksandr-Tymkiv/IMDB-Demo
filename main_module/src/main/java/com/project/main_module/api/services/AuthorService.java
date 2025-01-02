package com.project.main_module.api.services;

import com.project.main_module.dto.AlbumDTO;
import com.project.main_module.dto.AuthorDTO;
import com.project.main_module.dto.mappers.AuthorDTOMapper;
import com.project.main_module.models.Author;
import com.project.main_module.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorDTOMapper authorDTOMapper;

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository
                .findAll()
                .stream()
                .map(authorDTOMapper)
                .toList();
    }
}
