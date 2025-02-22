package com.joange.serviceImpl;

import com.joange.model.FamCurso;
import com.joange.reporitory.FamCursoRepo;
import com.joange.service.FamCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamCursoServiceImpl implements FamCursoService {

    @Autowired
    private FamCursoRepo famCursoRepo;

    @Override
    public List<FamCurso> findAll() {
        return famCursoRepo.findAll();
    }

    @Override
    public FamCurso findById(Long id) {
        return famCursoRepo.findById(id).orElse(null);
    }

    @Override
    public FamCurso save(FamCurso famCurso) {
        return famCursoRepo.save(famCurso);
    }

    @Override
    public void deleteById(Long id) {
        famCursoRepo.deleteById(id);
    }
}
