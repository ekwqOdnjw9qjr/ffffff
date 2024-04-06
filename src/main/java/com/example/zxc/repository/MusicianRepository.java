package com.example.zxc.repository;


import com.example.zxc.entity.Musician;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

}

