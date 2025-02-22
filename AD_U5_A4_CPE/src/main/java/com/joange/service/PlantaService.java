package com.joange.service;

import com.joange.model.Planta;
import java.util.List;
import java.util.Optional;

public interface PlantaService {
    List<Planta> findAll();
    Optional<Planta> findById(Long id);
    Planta save(Planta planta);
    void deleteById(Long id);
}
