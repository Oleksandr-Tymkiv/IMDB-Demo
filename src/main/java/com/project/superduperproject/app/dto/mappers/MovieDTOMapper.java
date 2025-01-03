package com.project.superduperproject.app.dto.mappers;

import com.project.superduperproject.app.dto.MovieDTO;
import com.project.superduperproject.app.models.Movie;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MovieDTOMapper implements Function<Movie, MovieDTO> {
    @Override
    public MovieDTO apply(Movie movie) {
        return MovieDTO.builder()
                .nameMovie(movie.getNameMovie())
                .description(movie.getDescription())
                .genre(movie.getGenre())
                .releaseDate(movie.getReleaseDate())
                .build();
    }
}
