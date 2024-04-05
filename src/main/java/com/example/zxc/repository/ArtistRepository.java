package com.example.zxc.repository;


import com.example.zxc.entity.Artist;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}

