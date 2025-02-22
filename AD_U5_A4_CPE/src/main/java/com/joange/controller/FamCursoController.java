package com.joange.controller;

import com.joange.model.FamCurso;
import com.joange.model.SubUsoAula;
import com.joange.service.FamCursoService;
import com.joange.service.SubUsoAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/famcurso")
public class FamCursoController {

    @Autowired
    private FamCursoService famCursoService;

    @Autowired
    private SubUsoAulaService subUsoAulaService;

    @GetMapping
    public String findAll(Model model) {
        // Listamos todos los famcursos
        List<FamCurso> listaFam = famCursoService.findAll();
        model.addAttribute("famCursos", listaFam);

        // Listamos subUsoAulas para el <select> en el formulario
        List<SubUsoAula> listaSubUso = subUsoAulaService.findAll();
        model.addAttribute("subUsoAulas", listaSubUso);

        // Creamos un objeto "nuevoFamCurso" para binding en el formulario
        model.addAttribute("nuevoFamCurso", new FamCurso());

        return "famCurso";  // Nombre de la plantilla Thymeleaf
    }

    @PostMapping
    public String save(@ModelAttribute("nuevoFamCurso") FamCurso famCurso) {
        // Guardamos el famCurso con la relación al subUsoAula ya establecida
        famCursoService.save(famCurso);
        return "redirect:/famcurso";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        famCursoService.deleteById(id);
        return "redirect:/famcurso";
    }
}
