package com.project.main_module.api.controllers;

import com.project.main_module.api.representation.AlbumRequest;
import com.project.main_module.api.services.AlbumService;
import com.project.main_module.api.services.MusicService;
import com.project.main_module.dto.AlbumDTO;
import com.project.main_module.dto.MusicDTO;
import com.project.main_module.models.Album;
import com.project.main_module.models.Music;
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
