package com.example.zxc.controller;

import com.example.zxc.entity.Musician;
import com.example.zxc.service.MusicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/musicians")
@RequiredArgsConstructor
public class MusicianController {
    private final MusicianService musicianService;

    @GetMapping
    public List<Musician> findAll(){
        return musicianService.findAllMusician();
    }

    @GetMapping("/musicians/{id}")
    public Musician getById(@PathVariable Long id){
        return musicianService.findMusicianById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMusician(@RequestBody Musician musician){
        musicianService.saveMusician(musician);
    }

    @PutMapping("/musician")
    public void updateMusician(@RequestBody Musician musician) {
        musicianService.updateMusician(musician);
    }

    @DeleteMapping("/musician/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMusician(@PathVariable Long id) {
        musicianService.deleteMusicianById(id);
    }
}
