package com.project.imdbdemo.app.api.controllers.moviesControllers;

import com.project.imdbdemo.app.api.representation.moviesRepresentation.MovieRequest;
import com.project.imdbdemo.app.api.services.movieServices.MovieService;
import com.project.imdbdemo.app.dto.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/save-movie")
    public void saveMovie(@RequestBody MovieRequest movieRequest) {
        movieService.saveMovie(movieRequest);
    }

    @GetMapping("/get-all-movie")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }
}
