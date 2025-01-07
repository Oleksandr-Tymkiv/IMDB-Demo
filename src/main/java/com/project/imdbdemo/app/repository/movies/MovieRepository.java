package com.project.imdbdemo.app.repository.movies;

import com.project.imdbdemo.app.models.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
