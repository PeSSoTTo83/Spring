package com.joange.controller;

import com.joange.model.Edificio;
import com.joange.model.Planta;
import com.joange.service.EdificioService;
import com.joange.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/plantas")
public class PlantaController {

    @Autowired
    private PlantaService plantaService;
    
    @Autowired
    private EdificioService edificioService;


    @GetMapping
    public String getAllPlantas(Model model) {
        List<Planta> plantas = plantaService.findAll();
        model.addAttribute("plantas", plantas);
        return "plantas";
    }

    @GetMapping("/detalle/{id}") // Cambiamos de "/{id}" a "/detalle/{id}"
    public String getPlantaById(@PathVariable Long id, Model model) {
        Optional<Planta> planta = plantaService.findById(id);
        planta.ifPresent(value -> model.addAttribute("planta", value));
        return "planta";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("planta", new Planta());
        model.addAttribute("edificios", edificioService.findAll());
        return "add-planta";
    }

    @PostMapping("/save")
    public String savePlanta(@ModelAttribute Planta planta) {
        // Supongamos que deseas asignar el Edificio con id 1
        Optional<Edificio> edificioOpt = edificioService.findById(1L);
        if (edificioOpt.isPresent()) {
            planta.setEdificio(edificioOpt.get());
        } else {
            // Manejar el caso de que el edificio no exista
        }
        plantaService.save(planta);
        return "redirect:/plantas";
    }


    @GetMapping("/delete/{id}")
    public String deletePlanta(@PathVariable Long id) {
        plantaService.deleteById(id);
        return "redirect:/plantas";
    }
}
