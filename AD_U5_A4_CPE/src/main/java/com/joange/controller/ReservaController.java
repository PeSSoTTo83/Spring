package com.joange.controller;

import com.joange.model.Reserva;
import com.joange.service.ReservaService;
// Importa también AulaService, UsuarioService, CursoService si quieres <select>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Si tienes servicios para Aula, Usuario, Curso, descomenta e inyecta:
    // @Autowired
    // private AulaService aulaService;
    // @Autowired
    // private UsuarioService usuarioService;
    // @Autowired
    // private CursoService cursoService;

    @GetMapping
    public String findAll(Model model) {
        List<Reserva> listaReservas = reservaService.findAll();
        model.addAttribute("reservas", listaReservas);

        // Para poblar selects, si lo deseas:
        // model.addAttribute("aulas", aulaService.findAll());
        // model.addAttribute("usuarios", usuarioService.findAll());
        // model.addAttribute("cursos", cursoService.findAll());

        model.addAttribute("nuevaReserva", new Reserva());
        return "reserva";
    }

    @PostMapping
    public String save(@ModelAttribute("nuevaReserva") Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reserva";
    }
    
    @GetMapping("/reservas/fechas")
    @ResponseBody
    public List<String> getFechasReservadas() {
        // Supongamos que reservaService.getFechasReservadas() devuelve List<Date>
        // Conviértelo a List<String> en formato "yyyy-MM-dd"
        List<Date> fechas = reservaService.getFechasReservadas();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return fechas.stream().map(df::format).collect(Collectors.toList());
    }
    
    @GetMapping("/reservas/eventos")
    @ResponseBody
    public List<Map<String, Object>> getEventosReserva() {
        List<Reserva> reservas = reservaService.findAll();
        List<Map<String, Object>> eventos = new ArrayList<>();
        
        // Usamos dos formateadores: uno para la fecha y otro para la hora.
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        
        for (Reserva r : reservas) {
            Map<String, Object> evento = new HashMap<>();
            evento.put("title", "Reserva ID: " + r.getIdreserva());
            
            // Construir el string de inicio combinando fechadesde y horadesde
            String start = "";
            if (r.getFechadesde() != null) {
                start = dateFormat.format(r.getFechadesde());
            }
            if (r.getHoradesde() != null) {
                start += "T" + timeFormat.format(r.getHoradesde());
            }
            evento.put("start", start);
            
            // Construir el string de fin combinando fechahasta y horahasta (si existen)
            String end = "";
            if (r.getFechahasta() != null) {
                end = dateFormat.format(r.getFechahasta());
            }
            if (r.getHorahasta() != null) {
                end += "T" + timeFormat.format(r.getHorahasta());
            }
            // Solo añadimos "end" si se ha construido algún valor
            if (!end.isEmpty()) {
                evento.put("end", end);
            }
            
            eventos.add(evento);
        }
        
        return eventos;
    }




    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        reservaService.deleteById(id);
        return "redirect:/reserva";
    }
}
