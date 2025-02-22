package com.joange.controller;

import com.joange.model.Reserva;
import com.joange.model.Aula;
import com.joange.model.Usuario;
import com.joange.model.Curso;
import com.joange.service.ReservaService;
import com.joange.service.AulaService;
import com.joange.service.UsuarioService;
import com.joange.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

@Controller
@RequestMapping("/reservausuario")
public class ReservaUsuarioController {

    @Autowired
    private ReservaService reservaService;
    
    @Autowired
    private AulaService aulaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String findAll(Model model) {
        // Cargar reservas existentes
        List<Reserva> listaReservas = reservaService.findAll();
        model.addAttribute("reservas", listaReservas);
        
        // Objeto para el formulario
        model.addAttribute("nuevaReserva", new Reserva());
        
        // Cargar listas para los desplegables
        List<Aula> listaAulas = aulaService.findAll();
        List<Usuario> listaUsuarios = usuarioService.findAll();
        List<Curso> listaCursos = cursoService.findAll();
        
        model.addAttribute("listaAulas", listaAulas);
        model.addAttribute("listaUsuarios", listaUsuarios);
        model.addAttribute("listaCursos", listaCursos);
        
        return "reservausuario";
    }

    @PostMapping
    public String save(@ModelAttribute("nuevaReserva") Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservausuario";
    }

    @GetMapping("/reservas/eventos")
    @ResponseBody
    public List<Map<String, Object>> getEventosReserva() {
        List<Reserva> reservas = reservaService.findAll();
        List<Map<String, Object>> eventos = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        for (Reserva r : reservas) {
            Map<String, Object> evento = new HashMap<>();
            evento.put("title", "Reserva ID: " + r.getIdreserva());

            String start = r.getFechadesde() != null ? dateFormat.format(r.getFechadesde()) : "";
            if (r.getHoradesde() != null) {
                start += "T" + timeFormat.format(r.getHoradesde());
            }
            evento.put("start", start);

            String end = r.getFechahasta() != null ? dateFormat.format(r.getFechahasta()) : "";
            if (r.getHorahasta() != null) {
                end += "T" + timeFormat.format(r.getHorahasta());
            }
            if (!end.isEmpty()) {
                evento.put("end", end);
            }

            eventos.add(evento);
        }

        return eventos;
    }
}
