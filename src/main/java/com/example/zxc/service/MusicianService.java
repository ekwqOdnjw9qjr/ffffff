package com.example.zxc.service;

import com.example.zxc.entity.Musician;
import com.example.zxc.repository.MusicianRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicianService {
    private final MusicianRepository musicianRepository;

    public List<Musician> findAllMusician(){
        return musicianRepository.findAll();
    }

    public Musician findMusicianById(Long id) {
        return musicianRepository.findById(id).orElseThrow(() -> new RuntimeException("Musician not found"));
    }

    public void saveMusician(Musician musician){
        musicianRepository.save(musician);
    }

    public void updateMusician(Musician newMusician) {
        Musician oldMusician = musicianRepository.findById(newMusician.getId())
                .orElseThrow(() ->new RuntimeException("Musician not found"));

        oldMusician.setName(newMusician.getName());

        musicianRepository.save(oldMusician);
    }

    public void deleteMusicianById(Long id ){
        musicianRepository.deleteById(id);
    }
}