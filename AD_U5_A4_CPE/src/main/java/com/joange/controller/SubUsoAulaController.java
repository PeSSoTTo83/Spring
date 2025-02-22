package com.joange.controller;

import com.joange.model.SubUsoAula;
import com.joange.service.SubUsoAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subusoaula")
public class SubUsoAulaController {

    @Autowired
    private SubUsoAulaService subUsoAulaService;

    // Listar todos los registros
    @GetMapping
    public String findAll(Model model) {
        List<SubUsoAula> lista = subUsoAulaService.findAll();
        model.addAttribute("subUsoAulas", lista);
        return "subUsoAula";  // Nombre de la plantilla Thymeleaf
    }

    // Guardar nuevo registro (o actualizar, si ya existe)
    @PostMapping
    public String save(@ModelAttribute SubUsoAula subUsoAula) {
        subUsoAulaService.save(subUsoAula);
        return "redirect:/subusoaula";
    }

    // Eliminar registro por ID
    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        subUsoAulaService.deleteById(id);
        return "redirect:/subusoaula";
    }
}
