package com.joange.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.joange.model.TipoAula;

public interface TipoAulaRepository extends JpaRepository<TipoAula, Long> {
    // Puedes añadir métodos personalizados si fuera necesario
}
