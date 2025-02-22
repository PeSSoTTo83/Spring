package com.joange.reporitory;

import com.joange.model.Aula;
import com.joange.model.Planta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AulaRepo extends JpaRepository<Aula, Long> {

    // Buscar aulas por id de planta
	List<Aula> findByPlantaIdPlanta(Long idPlanta);

    // Buscar aulas con capacidad mayor o igual a un valor
    List<Aula> findByCapacidadGreaterThanEqual(int capacidad);
}


