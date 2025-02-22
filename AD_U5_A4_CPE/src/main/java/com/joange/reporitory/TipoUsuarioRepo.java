package com.joange.reporitory;

import com.joange.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepo extends JpaRepository<TipoUsuario, Long> {
}
