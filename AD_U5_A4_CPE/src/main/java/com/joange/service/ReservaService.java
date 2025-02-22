package com.joange.service;

import com.joange.model.Reserva;

import java.util.Date;
import java.util.List;

public interface ReservaService {
    List<Reserva> findAll();
    Reserva findById(Long id);
    Reserva save(Reserva reserva);
    void deleteById(Long id);
	List<Date> getFechasReservadas();
}
