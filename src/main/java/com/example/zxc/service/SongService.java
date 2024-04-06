package com.example.zxc.service;

import com.example.zxc.entity.Song;
import com.example.zxc.repository.SongRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;

    public List<Song> findAllSong(){
        return songRepository.findAll();
    }

    public Song findSongById(Long id ){
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found with id: " ));
    }

    public Song saveSong(Song song){
        return songRepository.save(song);
    }

    public void updateSong( Song newSong) {
        Song oldSong = songRepository.findById(newSong.getId())
                .orElseThrow(() -> new RuntimeException("Song not found with id: " ));

        oldSong.setName(newSong.getName());

        songRepository.save(oldSong);
    }

    public void deleteSongById(Long id ){
        songRepository.deleteById(id);
    }
}