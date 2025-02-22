package com.joange.controller;

import com.joange.model.UsoAula;
import com.joange.service.UsoAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usoaula")
public class UsoAulaController {

    @Autowired
    private UsoAulaService usoAulaService;

    @GetMapping
    public String findAll(Model model) {
        List<UsoAula> usoAulas = usoAulaService.findAll();
        model.addAttribute("usoAulas", usoAulas);
        return "usoAula"; // Retorna la vista usoAula.html
    }

    @PostMapping
    public String save(@ModelAttribute UsoAula usoAula) {
        usoAulaService.save(usoAula);
        return "redirect:/usoaula"; // Redirige a la lista después de agregar
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        usoAulaService.deleteById(id);
        return "redirect:/usoaula"; // Redirige a la lista después de eliminar
    }
}
