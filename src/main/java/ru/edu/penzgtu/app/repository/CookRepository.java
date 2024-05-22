package ru.edu.penzgtu.app.repository;


import ru.edu.penzgtu.app.entity.Cook;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CookRepository extends JpaRepository<Cook, Long> {

}

