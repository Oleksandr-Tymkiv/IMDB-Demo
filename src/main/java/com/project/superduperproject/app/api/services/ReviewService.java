package com.project.superduperproject.app.api.services;

import com.project.superduperproject.app.api.representation.ReviewRequest;
import com.project.superduperproject.app.dto.ReviewDTO;
import com.project.superduperproject.app.dto.mappers.ReviewDTOMapper;
import com.project.superduperproject.app.models.Movie;
import com.project.superduperproject.app.models.Review;
import com.project.superduperproject.app.repository.MovieRepository;
import com.project.superduperproject.app.repository.ReviewRepository;
import com.project.superduperproject.security.users.models.User;
import com.project.superduperproject.security.users.repositories.UserRepository;
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
