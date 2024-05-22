package ru.edu.penzgtu.app.repository;

import ru.edu.penzgtu.app.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{
}
