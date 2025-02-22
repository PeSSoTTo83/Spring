package com.joange.serviceImpl;

import com.joange.model.Planta;
import com.joange.reporitory.PlantaRepo;
import com.joange.service.PlantaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlantaServiceImpl implements PlantaService {

    @Autowired
    private PlantaRepo plantaRepository;

    @Override
    public List<Planta> findAll() {
        return plantaRepository.findAll();
    }

    @Override
    public Optional<Planta> findById(Long id) {
        return plantaRepository.findById(id);
    }

    @Override
    public Planta save(Planta planta) {
        return plantaRepository.save(planta);
    }

    @Override
    public void deleteById(Long id) {
        plantaRepository.deleteById(id);
    }
}
