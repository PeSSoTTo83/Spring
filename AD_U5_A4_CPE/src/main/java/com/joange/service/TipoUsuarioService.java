package com.joange.service;

import com.joange.model.TipoUsuario;

import java.util.List;

public interface TipoUsuarioService {
    List<TipoUsuario> findAll();
    TipoUsuario findById(Long id);
    TipoUsuario save(TipoUsuario tipoUsuario);
    void deleteById(Long id);
}
