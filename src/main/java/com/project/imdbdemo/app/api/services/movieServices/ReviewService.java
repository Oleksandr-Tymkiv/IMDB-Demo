package com.project.imdbdemo.app.api.services.movieServices;

import com.project.imdbdemo.app.api.representation.moviesRepresentation.ReviewRequest;
import com.project.imdbdemo.app.dto.ReviewDTO;
import com.project.imdbdemo.app.dto.mappers.ReviewDTOMapper;
import com.project.imdbdemo.app.models.movie.Movie;
import com.project.imdbdemo.app.models.movie.Review;
import com.project.imdbdemo.app.repository.movies.MovieRepository;
import com.project.imdbdemo.app.repository.movies.ReviewRepository;
import com.project.imdbdemo.app.models.user.User;
import com.project.imdbdemo.app.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ReviewDTOMapper reviewDTOMapper;

    public void saveReview (Long idUser, Long idMovie, ReviewRequest reviewRequest) {
        Movie movie = movieRepository.findById(idMovie)
                .orElseThrow(()-> new IllegalStateException("Movie not found"));
        User user = userRepository.findById(idUser)
                .orElseThrow(()-> new IllegalStateException("User not found"));
        reviewRepository.save(Review.builder()
                        .reviewText(reviewRequest.reviewText())
                        .createdDate(reviewRequest.createdDate())
                        .rating(reviewRequest.rating())
                        .movie(movie)
                        .user(user)
                        .movie(movie)
                .build());
    }

    public List<ReviewDTO> getAllReviews() {
        return reviewRepository
                .findAll()
                .stream()
                .map(reviewDTOMapper)
                .toList();
    }
}
