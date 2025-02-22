package com.joange.serviceImpl;

import com.joange.model.SubUsoAula;
import com.joange.reporitory.SubUsoAulaRepo;
import com.joange.service.SubUsoAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubUsoAulaServiceImpl implements SubUsoAulaService {

    @Autowired
    private SubUsoAulaRepo subUsoAulaRepo;

    @Override
    public List<SubUsoAula> findAll() {
        return subUsoAulaRepo.findAll();
    }

    @Override
    public SubUsoAula findById(Long id) {
        return subUsoAulaRepo.findById(id).orElse(null);
    }

    @Override
    public SubUsoAula save(SubUsoAula subUsoAula) {
        return subUsoAulaRepo.save(subUsoAula);
    }

    @Override
    public void deleteById(Long id) {
        subUsoAulaRepo.deleteById(id);
    }
}
