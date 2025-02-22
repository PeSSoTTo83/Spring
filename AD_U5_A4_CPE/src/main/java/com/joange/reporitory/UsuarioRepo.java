package com.joange.reporitory;

import com.joange.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
