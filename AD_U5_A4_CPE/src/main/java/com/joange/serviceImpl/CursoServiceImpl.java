package com.joange.serviceImpl;

import com.joange.model.Curso;
import com.joange.reporitory.CursoRepo;
import com.joange.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepo cursoRepo;

    @Override
    public List<Curso> findAll() {
        return cursoRepo.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepo.findById(id).orElse(null);
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepo.save(curso);
    }

    @Override
    public void deleteById(Long id) {
        cursoRepo.deleteById(id);
    }
}
