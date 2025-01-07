package com.project.imdbdemo.app.dto.mappers;

import com.project.imdbdemo.app.dto.ReviewDTO;
import com.project.imdbdemo.app.models.movie.Review;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ReviewDTOMapper implements Function<Review, ReviewDTO> {
    @Override
    public ReviewDTO apply(Review review) {
        return ReviewDTO.builder()
                .reviewText(review.getReviewText())
                .rating(review.getRating())
                .createdDate(review.getCreatedDate())
                .userName(review.getUser().getUsername())
                .movieName(review.getMovie().getNameMovie())
                .build();
    }
}
