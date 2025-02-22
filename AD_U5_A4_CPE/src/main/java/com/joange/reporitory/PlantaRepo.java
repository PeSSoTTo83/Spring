package com.joange.reporitory;

import com.joange.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlantaRepo extends JpaRepository<Planta, Long> {

    @Query("SELECT p FROM Planta p WHERE p.activo = true")
    List<Planta> findActivePlantas();

    @Query("SELECT p FROM Planta p WHERE p.edificio.idEdificio = :idEdificio")
    List<Planta> findByEdificio(@Param("idEdificio") Long idEdificio);

    @Query("SELECT p FROM Planta p WHERE p.nAulasDocentes >= :nAulas")
    List<Planta> findByMinAulas(@Param("nAulas") int nAulas);
}