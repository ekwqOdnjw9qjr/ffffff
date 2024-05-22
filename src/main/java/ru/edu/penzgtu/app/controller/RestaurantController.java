package ru.edu.penzgtu.app.controller;

import ru.edu.penzgtu.app.entity.Restaurant;
import ru.edu.penzgtu.app.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;


    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }


    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.findRestaurantById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }


    @PutMapping("/restaurant/{id}")
    public void updateRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.updateRestaurant(restaurant);
    }


    @DeleteMapping("/restaurant/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
    }
}
