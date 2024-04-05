package com.example.zxc.controller;

import com.example.zxc.entity.Picture;
import com.example.zxc.service.PictureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pictures")
public class PictureController {
    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }


    @GetMapping
    public List<Picture> getAllPicture() {
        return pictureService.findAllPicture();
    }


    @GetMapping("/picture/{id}")
    public Picture getPictureById(@PathVariable Long id) {
        return pictureService.findPictureById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Picture createPicture(@RequestBody Picture picture) {
        return pictureService.savePicture(picture);
    }


    @PutMapping("/picture/{id}")
    public void updatePicture(@RequestBody Picture picture) {
        pictureService.updatePicture(picture);
    }


    @DeleteMapping("/picture/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePicture(@PathVariable Long id) {
        pictureService.deletePictureById(id);
    }
}
