package com.joange.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.joange.model.UsoAula;
import com.joange.reporitory.UsoAulaRepo;
import com.joange.service.UsoAulaService;

@Service
public class UsoAulaServiceImpl implements UsoAulaService {

    @Autowired
    private UsoAulaRepo usoAulaRepo;

    @Override
    public List<UsoAula> findAll() {
        return usoAulaRepo.findAll();
    }

    @Override
    public UsoAula findById(Long id) {
        return usoAulaRepo.findById(id).orElse(null);
    }

    @Override
    public UsoAula save(UsoAula usoAula) {
        return usoAulaRepo.save(usoAula);
    }

    @Override
    public void deleteById(Long id) {
    	usoAulaRepo.deleteById(id);
    }
}
