package com.joange.controller;

import com.joange.model.Edificio;
import com.joange.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EdificioController {

    @Autowired
    private EdificioService edificioService;

    // Obtener todos los edificios
    @GetMapping("/edificios")
    public String getAllEdificios(Model model) {
        List<Edificio> edificios = edificioService.findAll();
        model.addAttribute("edificios", edificios);
        model.addAttribute("all", true);
        return "edificios";
    }

    // Obtener un edificio por su ID
    @GetMapping("/edificios/{id}")
    public String getEdificioById(@PathVariable Long id, Model model) {
        Optional<Edificio> edificioOptional = edificioService.findById(id);
        if (edificioOptional.isPresent()) {
            model.addAttribute("vacio", false);
            model.addAttribute("edificio", edificioOptional.get());
        } else {
            model.addAttribute("vacio", true);
            model.addAttribute("msg", "No se encontró un edificio con ID " + id);
        }
        return "edificios";
    }

    // Mostrar formulario para agregar un edificio
    @GetMapping("/edificio/add")
    public String addEdificio(Model model) {
        Edificio edificio = new Edificio();
        model.addAttribute("edificio", edificio);
        model.addAttribute("nuevo", true);
        return "add-edificio";
    }

    // Guardar un nuevo edificio
    @PostMapping("/edificio/save")
    public String saveEdificio(@ModelAttribute("edificio") Edificio edificio) {
        edificioService.save(edificio);
        return "redirect:/edificios";
    }

    // Mostrar formulario para actualizar un edificio
    @GetMapping("/edificio/update/{id}")
    public String updateEdificio(@PathVariable Long id, Model model) {
        Optional<Edificio> edificio = edificioService.findById(id);
        if (edificio.isPresent()) {
            model.addAttribute("edificio", edificio.get());
            model.addAttribute("nuevo", false);
            return "add-edificio";
        } else {
            return "redirect:/edificios";
        }
    }

    // Procesar actualización de un edificio
    @PostMapping("/edificio/update/{id}")
    public String processUpdateEdificio(@PathVariable Long id, @ModelAttribute Edificio edificio) {
        edificio.setIdEdificio(id);
        edificioService.save(edificio); // Actualiza el edificio
        return "redirect:/edificios";
    }

    // Eliminar un edificio
    @GetMapping("/edificio/delete/{id}")
    public String deleteEdificio(@PathVariable Long id) {
        edificioService.deleteById(id);
        return "redirect:/edificios";
    }
}
