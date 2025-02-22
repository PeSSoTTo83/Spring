package com.joange.service;

import com.joange.model.Curso;
import java.util.List;

public interface CursoService {
    List<Curso> findAll();
    Curso findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
}
