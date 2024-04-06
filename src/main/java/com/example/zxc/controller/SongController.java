package com.example.zxc.controller;

import com.example.zxc.entity.Song;
import com.example.zxc.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;


    @GetMapping
    public List<Song> getAllSong() {
        return songService.findAllSong();
    }


    @GetMapping("/song/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songService.findSongById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Song createSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }


    @PutMapping("/song/{id}")
    public void updateSong(@RequestBody Song song) {
        songService.updateSong(song);
    }


    @DeleteMapping("/song/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSong(@PathVariable Long id) {
        songService.deleteSongById(id);
    }
}
