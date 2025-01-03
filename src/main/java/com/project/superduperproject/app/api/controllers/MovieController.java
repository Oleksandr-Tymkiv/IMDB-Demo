package com.project.superduperproject.app.api.controllers;

import com.project.superduperproject.app.api.representation.MovieRequest;
import com.project.superduperproject.app.api.services.MovieService;
import com.project.superduperproject.app.dto.MovieDTO;
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
