package com.joange.service;

import com.joange.model.FamCurso;
import java.util.List;

public interface FamCursoService {
    List<FamCurso> findAll();
    FamCurso findById(Long id);
    FamCurso save(FamCurso famCurso);
    void deleteById(Long id);
}
