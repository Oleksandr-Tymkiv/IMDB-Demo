package com.project.main_module.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "_author_")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @SequenceGenerator(
            name = "sequence_author",
            sequenceName = "sequence_author",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "sequence_author",
            strategy = GenerationType.SEQUENCE
    )
    private Long idAuthor;
    private String authorName;
    private String bio;
    private String genre;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Album> albums;

}
