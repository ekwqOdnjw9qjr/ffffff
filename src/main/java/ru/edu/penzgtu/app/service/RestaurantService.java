package ru.edu.penzgtu.app.service;

import ru.edu.penzgtu.app.entity.Restaurant;
import ru.edu.penzgtu.app.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> findAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant findRestaurantById(Long id ){
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id"));
    }

    public Restaurant saveRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public void updateRestaurant( Restaurant newRestaurant) {
        Restaurant oldRestaurant = restaurantRepository.findById(newRestaurant.getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id"));
        oldRestaurant.setName(newRestaurant.getName());
        restaurantRepository.save(oldRestaurant);
    }

    public void deleteRestaurantById(Long id ){
        restaurantRepository.deleteById(id);
    }
}