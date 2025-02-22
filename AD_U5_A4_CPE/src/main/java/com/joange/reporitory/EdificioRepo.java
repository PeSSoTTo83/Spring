package com.joange.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.joange.model.Edificio;

public interface EdificioRepo extends JpaRepository<Edificio, Long> {

    // Buscar todos los edificios activos
    @Query("SELECT e FROM Edificio e WHERE e.activo = true")
    List<Edificio> findActiveEdificios();

    // Buscar edificios por ubicación
    @Query("SELECT e FROM Edificio e WHERE e.ubicacion = :ubicacion")
    List<Edificio> findByUbicacion(@Param("ubicacion") String ubicacion);

    // Buscar edificios con un número mínimo de aulas
    @Query("SELECT e FROM Edificio e WHERE e.nAulas >= :nAulas")
    List<Edificio> findByMinAulas(@Param("nAulas") int nAulas);

}
