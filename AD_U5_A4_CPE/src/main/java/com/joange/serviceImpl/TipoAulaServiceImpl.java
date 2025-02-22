package com.joange.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.joange.model.TipoAula;
import com.joange.reporitory.TipoAulaRepository;
import com.joange.service.TipoAulaService;

@Service
public class TipoAulaServiceImpl implements TipoAulaService {

    @Autowired
    private TipoAulaRepository tipoAulaRepository;

    @Override
    public List<TipoAula> findAll() {
        return tipoAulaRepository.findAll();
    }

    @Override
    public TipoAula findById(Long id) {
        return tipoAulaRepository.findById(id).orElse(null);
    }

    @Override
    public TipoAula save(TipoAula tipoAula) {
        return tipoAulaRepository.save(tipoAula);
    }

    @Override
    public void deleteById(Long id) {
        tipoAulaRepository.deleteById(id);
    }
}
