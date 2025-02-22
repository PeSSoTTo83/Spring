package com.joange.controller;

import com.joange.model.Curso;
import com.joange.model.FamCurso;
import com.joange.service.CursoService;
import com.joange.service.FamCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private FamCursoService famCursoService;

    @GetMapping
    public String findAll(Model model) {
        // Listamos todos los cursos
        List<Curso> listaCursos = cursoService.findAll();
        model.addAttribute("cursos", listaCursos);

        // Listamos FamCurso para poblar el <select>
        List<FamCurso> listaFam = famCursoService.findAll();
        model.addAttribute("famCursos", listaFam);

        // Creamos un objeto "nuevoCurso" para el formulario
        model.addAttribute("nuevoCurso", new Curso());

        return "curso"; // Nombre de la plantilla Thymeleaf
    }

    @PostMapping
    public String save(@ModelAttribute("nuevoCurso") Curso curso) {
        // Guardamos el curso (el "famcurso" será el ID del famcurso seleccionado)
        cursoService.save(curso);
        return "redirect:/curso";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        cursoService.deleteById(id);
        return "redirect:/curso";
    }
}
