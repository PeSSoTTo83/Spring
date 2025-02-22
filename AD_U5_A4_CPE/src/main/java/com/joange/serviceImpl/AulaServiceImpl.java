package com.joange.serviceImpl;

import com.joange.model.Aula;
import com.joange.reporitory.AulaRepo;
import com.joange.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepo aulaRepo;

    @Override
    public List<Aula> findAll() {
        return aulaRepo.findAll();
    }

    @Override
    public Optional<Aula> findById(Long id) {
        return aulaRepo.findById(id);
    }

    @Override
    public List<Aula> findByPlanta(Long idPlanta) {
        return aulaRepo.findByPlantaIdPlanta(idPlanta); // Asegúrate de que PlantaIdplanta es correcto
    }

    @Override
    public List<Aula> findByCapacidadMinima(int capacidad) {
        return aulaRepo.findByCapacidadGreaterThanEqual(capacidad);
    }


    @Override
    public Aula save(Aula aula) {
        return aulaRepo.save(aula);
    }

    @Override
    public void deleteById(Long id) {
        aulaRepo.deleteById(id);
    }
}
