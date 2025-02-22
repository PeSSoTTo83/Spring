package com.joange.reporitory;

import com.joange.model.FamCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamCursoRepo extends JpaRepository<FamCurso, Long> {
}
