package com.joange.service;

import java.util.List;
import com.joange.model.TipoAula;

public interface TipoAulaService {
    List<TipoAula> findAll();
    TipoAula findById(Long id);
    TipoAula save(TipoAula tipoAula);
    void deleteById(Long id);
}
