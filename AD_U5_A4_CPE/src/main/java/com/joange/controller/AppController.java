package com.joange.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Value("${aplicacion.nombre}")
    private String titulo;

    // Mapea /index para los usuarios logueados (por ejemplo, admin)
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("titulo", titulo);
        return "index";
    }
    
    // Elimina o comenta este método para que "/" no devuelva index.html
    /*
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("titulo", titulo);
        return "index";
    }
    */
}
