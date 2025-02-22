package com.joange.service;

import com.joange.model.Aula;
import java.util.List;
import java.util.Optional;

public interface AulaService {

    List<Aula> findAll();
    
    Optional<Aula> findById(Long id);

    List<Aula> findByPlanta(Long idPlanta);

    List<Aula> findByCapacidadMinima(int capacidad);

    Aula save(Aula aula);

    void deleteById(Long id);
}
