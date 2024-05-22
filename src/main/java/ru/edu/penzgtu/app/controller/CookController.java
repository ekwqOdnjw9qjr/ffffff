package ru.edu.penzgtu.app.controller;

import ru.edu.penzgtu.app.entity.Cook;
import ru.edu.penzgtu.app.service.CookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cooks")
@RequiredArgsConstructor
public class CookController {
    private final CookService cookService;

    @GetMapping
    public List<Cook> findAllCook(){
        return cookService.findAllCooks();
    }

    @GetMapping("/cook/{id}")
    public Cook getCookById(@PathVariable Long id){
        return cookService.findCookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCook(@RequestBody Cook cook){
        cookService.saveCook(cook);
    }

    @PutMapping("/cook")
    public void updateCook(@RequestBody Cook cook) {
        cookService.updateCook(cook);
    }

    @DeleteMapping("/cook/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCook(@PathVariable Long id) {
        cookService.deleteCookById(id);
    }
}
