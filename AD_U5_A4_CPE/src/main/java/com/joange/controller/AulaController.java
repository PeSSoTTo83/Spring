package com.joange.controller;

import com.joange.model.Aula;
import com.joange.model.Planta;
import com.joange.service.AulaService;
import com.joange.service.PlantaService;
import com.joange.service.TipoAulaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @Autowired
    private PlantaService plantaService;
    
    @Autowired
    private TipoAulaService tipoAulaService;  // Inyecta el servicio de TipoAula

    @GetMapping
    public String getAllAulas(Model model) {
        model.addAttribute("aulas", aulaService.findAll());
        return "aulas";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("aula", new Aula());
        model.addAttribute("plantas", plantaService.findAll());
        model.addAttribute("tiposAula", tipoAulaService.findAll());
        return "add-aula";
    }

    @PostMapping("/save")
    public String saveAula(@ModelAttribute Aula aula) {
        aulaService.save(aula);
        return "redirect:/aulas";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Aula> aulaOpt = aulaService.findById(id);
        if (aulaOpt.isPresent()) {
            model.addAttribute("aula", aulaOpt.get());
            model.addAttribute("plantas", plantaService.findAll());
            model.addAttribute("tiposAula", tipoAulaService.findAll());
            return "edit-aula";
        } else {
            return "redirect:/aulas";
        }
    }
    @GetMapping("/{id}")
    public String viewAula(@PathVariable Long id, Model model) {
        Optional<Aula> aulaOpt = aulaService.findById(id);
        if (aulaOpt.isPresent()) {
            model.addAttribute("aula", aulaOpt.get());
            return "aula";  // Aquí se usa "aula", ya que el archivo se llama aula.html
        } else {
            return "redirect:/aulas";
        }
    }


    // Otros métodos (delete, etc.)...
    
    @GetMapping("/delete/{id}")
    public String deleteAula(@PathVariable Long id) {
        aulaService.deleteById(id);
        return "redirect:/aulas";
    }

}
