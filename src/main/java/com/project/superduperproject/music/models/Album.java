package com.project.superduperproject.music.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "_album_")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @SequenceGenerator(
            name = "sequence_album",
            sequenceName = "sequence_album",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "sequence_album",
            strategy = GenerationType.SEQUENCE
    )
    private Long idAlbum;
    private String nameAlbum;
    private LocalDate releaseDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Music> music;
}
