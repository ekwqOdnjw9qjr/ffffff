package com.example.zxc.service;

import com.example.zxc.entity.Artist;
import com.example.zxc.repository.ArtistRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public List<Artist> findAllArtists(){
        return artistRepository.findAll();
    }

    public Artist findArtistById(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    public void saveArtist(Artist artist){
        artistRepository.save(artist);
    }

    public void updateArtist(Artist newArtist) {
        Artist oldArtist = artistRepository.findById(newArtist.getId())
                .orElseThrow(() ->new RuntimeException("Artist not found"));

        oldArtist.setName(newArtist.getName());

        artistRepository.save(oldArtist);
    }

    public void deleteArtistById(Long id ){
        artistRepository.deleteById(id);
    }
}