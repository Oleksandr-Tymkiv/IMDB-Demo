package com.project.superduperproject.music.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="_music_")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    @SequenceGenerator(
            name = "sequence_music",
            sequenceName = "sequence_music",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "sequence_music",
            strategy = GenerationType.SEQUENCE
    )
    private Long idMusic;
    private String title;
    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;
}
