package com.joange.controller;

import com.joange.model.TipoUsuario;
import com.joange.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipousuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public String findAll(Model model) {
        // Lista de tipos de usuario
        List<TipoUsuario> lista = tipoUsuarioService.findAll();
        model.addAttribute("tipoUsuarios", lista);

        return "tipoUsuario"; // Nombre de la plantilla Thymeleaf
    }

    @PostMapping
    public String save(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioService.save(tipoUsuario);
        return "redirect:/tipousuario";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        tipoUsuarioService.deleteById(id);
        return "redirect:/tipousuario";
    }
}
