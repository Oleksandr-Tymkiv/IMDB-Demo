package com.project.main_module.api.controllers;

import com.project.main_module.api.representation.MusicRequest;
import com.project.main_module.api.services.MusicService;
import com.project.main_module.dto.MusicDTO;
import com.project.main_module.models.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/music")
public class MusicController {
    private final MusicService musicService;

    @PostMapping("/save-music")
    public void saveMusic(@RequestBody MusicRequest musicRequest) {
        musicService.saveMusic(musicRequest);
    }

    @GetMapping("/get-all-music")
    public ResponseEntity<List<MusicDTO>> getAllMusics() {
        return ResponseEntity.ok(musicService.getAllMusics());
    }
}
