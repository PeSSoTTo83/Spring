package com.joange.service;

import com.joange.model.UsoAula;
import java.util.List;

public interface UsoAulaService {
    List<UsoAula> findAll();
    UsoAula findById(Long id);
    UsoAula save(UsoAula usoAula);
    void deleteById(Long id);
}
