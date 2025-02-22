package com.joange.service;

import com.joange.model.Edificio;
import java.util.List;
import java.util.Optional;

public interface EdificioService {

    // Obtener todos los edificios
    List<Edificio> findAll();
    
    // Buscar un edificio por su ID
    Optional<Edificio> findById(Long id);
    
    // Guardar o actualizar un edificio
    Edificio save(Edificio edificio);
    
    // Eliminar un edificio por su ID
    void deleteById(Long id);
}
