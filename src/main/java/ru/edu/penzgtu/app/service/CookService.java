package ru.edu.penzgtu.app.service;

import ru.edu.penzgtu.app.entity.Cook;
import ru.edu.penzgtu.app.repository.CookRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CookService {
    private final CookRepository cookRepository;

    public List<Cook> findAllCooks(){
        return cookRepository.findAll();
    }

    public Cook findCookById(Long id) {
        return cookRepository.findById(id).orElseThrow(() -> new RuntimeException("Cook not found"));
    }

    public void saveCook(Cook cook){
        cookRepository.save(cook);
    }

    public void updateCook(Cook newCook) {
        Cook oldCook = cookRepository.findById(newCook.getId())
                .orElseThrow(() ->new RuntimeException("Cook not found"));
        oldCook.setName(newCook.getName());
        cookRepository.save(oldCook);
    }

    public void deleteCookById(Long id ){
        cookRepository.deleteById(id);
    }
}