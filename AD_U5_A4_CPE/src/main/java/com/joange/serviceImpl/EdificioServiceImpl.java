package com.joange.serviceImpl;

import com.joange.model.Edificio;
import com.joange.reporitory.EdificioRepo;
import com.joange.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdificioServiceImpl implements EdificioService {

    @Autowired
    private EdificioRepo edificioRepo;

    @Override
    public List<Edificio> findAll() {
        return edificioRepo.findAll();
    }

    @Override
    public Optional<Edificio> findById(Long id) {
        return edificioRepo.findById(id);
    }

    @Override
    public Edificio save(Edificio edificio) {
        return edificioRepo.save(edificio);
    }

 
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		edificioRepo.deleteById(id);
	}
}
