package com.project.superduperproject.app.api.controllers;

import com.project.superduperproject.app.api.representation.ReviewRequest;
import com.project.superduperproject.app.api.services.ReviewService;
import com.project.superduperproject.app.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/save-review/{idUser}/{idMovie}")
    public void saveMusic(@PathVariable("idUser") Long idUser,
                          @PathVariable("idMovie") Long idMovie,
                          @RequestBody ReviewRequest reviewRequest) {
        reviewService.saveReview(idUser, idMovie,reviewRequest);
    }

    @GetMapping("/get-all-review")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }
}
