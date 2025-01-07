package com.project.imdbdemo.app.models.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.imdbdemo.app.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="_reviews_")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @SequenceGenerator(
            name = "sequence_review",
            sequenceName = "sequence_review",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "sequence_review",
            strategy = GenerationType.SEQUENCE
    )
    private Long idReview;
    private String reviewText;
    private LocalDateTime createdDate;
    private Integer rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movie", nullable = false)
    @JsonIgnore
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private User user;
}
