package com.example.zxc.controller;

import com.example.zxc.entity.Artist;
import com.example.zxc.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping
    public List<Artist> findAll(){
        return artistService.findAllArtists();
    }

    @GetMapping("/artists/{id}")
    public Artist getById(@PathVariable Long id){
        return artistService.findArtistById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createArtist(@RequestBody Artist artist){
        artistService.saveArtist(artist);
    }

    @PutMapping("/artist")
    public void updateArtist(@RequestBody Artist artist) {
        artistService.updateArtist(artist);
    }

    @DeleteMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtistById(id);
    }
}
