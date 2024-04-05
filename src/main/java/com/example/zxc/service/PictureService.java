package com.example.zxc.service;

import com.example.zxc.entity.Picture;
import com.example.zxc.repository.PictureRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository;

    public List<Picture> findAllPicture(){
        return pictureRepository.findAll();
    }

    public Picture findPictureById(Long id ){
        return pictureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Picture not found with id: " ));
    }

    public Picture savePicture(Picture picture){
        return pictureRepository.save(picture);
    }

    public void updatePicture( Picture newPicture) {
        Picture oldPicture = pictureRepository.findById(newPicture.getId())
                .orElseThrow(() -> new RuntimeException("Picture not found with id: " ));

        oldPicture.setName(newPicture.getName());

        pictureRepository.save(oldPicture);
    }

    public void deletePictureById(Long id ){
        pictureRepository.deleteById(id);
    }
}