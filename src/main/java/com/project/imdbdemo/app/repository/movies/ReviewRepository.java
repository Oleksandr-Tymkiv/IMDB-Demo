package com.project.imdbdemo.app.repository.movies;

import com.project.imdbdemo.app.models.movie.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
