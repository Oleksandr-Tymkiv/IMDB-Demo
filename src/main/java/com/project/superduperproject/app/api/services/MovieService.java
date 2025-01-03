package com.project.superduperproject.app.api.services;

import com.project.superduperproject.app.api.representation.MovieRequest;
import com.project.superduperproject.app.dto.MovieDTO;
import com.project.superduperproject.app.dto.mappers.MovieDTOMapper;
import com.project.superduperproject.app.models.Movie;
import com.project.superduperproject.app.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieDTOMapper movieDTOMapper;

    public void saveMovie(MovieRequest movieRequest) {
        movieRepository.save(Movie.builder()
                        .nameMovie(movieRequest.nameMovie())
                        .description(movieRequest.description())
                        .genre(movieRequest.genre())
                        .releaseDate(movieRequest.releaseDate())
                .build());
    }

    public List<MovieDTO> getAllMovies() {
        return movieRepository
                .findAll()
                .stream()
                .map(movieDTOMapper)
                .toList();
    }
}
