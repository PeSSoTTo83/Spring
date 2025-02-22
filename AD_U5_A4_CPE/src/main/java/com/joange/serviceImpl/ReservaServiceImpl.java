package com.joange.serviceImpl;

import com.joange.model.Reserva;
import com.joange.reporitory.ReservaRepo;
import com.joange.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepo reservaRepo;

    @Override
    public List<Reserva> findAll() {
        return reservaRepo.findAll();
    }

    @Override
    public Reserva findById(Long id) {
        return reservaRepo.findById(id).orElse(null);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepo.save(reserva);
    }

    @Override
    public void deleteById(Long id) {
        reservaRepo.deleteById(id);
    }

    @Override
    public List<Date> getFechasReservadas() {
        List<Reserva> reservas = reservaRepo.findAll();
        List<Date> fechas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            // Agregamos la fecha de inicio si existe
            if (reserva.getFechadesde() != null) {
                fechas.add(reserva.getFechadesde());
            }
            // Si deseas incluir también la fecha de fin:
            if (reserva.getFechahasta() != null) {
                fechas.add(reserva.getFechahasta());
            }
        }
        return fechas;
    }


	
}
