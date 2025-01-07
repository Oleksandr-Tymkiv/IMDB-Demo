package com.project.imdbdemo.app.api.services.movieServices;

import com.project.imdbdemo.app.api.representation.moviesRepresentation.MovieRequest;
import com.project.imdbdemo.app.dto.MovieDTO;
import com.project.imdbdemo.app.dto.mappers.MovieDTOMapper;
import com.project.imdbdemo.app.models.movie.Movie;
import com.project.imdbdemo.app.repository.movies.MovieRepository;
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
