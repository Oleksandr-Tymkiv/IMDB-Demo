package com.project.superduperproject.music.api.controllers;

import com.project.superduperproject.music.api.representation.AlbumRequest;
import com.project.superduperproject.music.api.services.AlbumService;
import com.project.superduperproject.music.api.services.MusicService;
import com.project.superduperproject.music.dto.AlbumDTO;
import com.project.superduperproject.music.dto.MusicDTO;
import com.project.superduperproject.music.models.Album;
import com.project.superduperproject.music.models.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/album")
public class AlbumController {
    private final AlbumService albumService;

    @PostMapping("/save-album")
    public void saveAlbum(@RequestBody AlbumRequest albumRequest) {
        albumService.saveAlbum(albumRequest);
    }

    @GetMapping("/get-all-album")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }
}
