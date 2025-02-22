package com.joange.service;

import com.joange.model.SubUsoAula;
import java.util.List;

public interface SubUsoAulaService {
    List<SubUsoAula> findAll();
    SubUsoAula findById(Long id);
    SubUsoAula save(SubUsoAula subUsoAula);
    void deleteById(Long id);
}
