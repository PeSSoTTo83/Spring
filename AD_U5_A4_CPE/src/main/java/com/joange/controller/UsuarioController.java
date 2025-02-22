package com.joange.controller;

import com.joange.model.TipoUsuario;
import com.joange.model.Usuario;
import com.joange.service.TipoUsuarioService;
import com.joange.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public String findAll(Model model) {
        // Listar usuarios
        List<Usuario> listaUsuarios = usuarioService.findAll();
        model.addAttribute("usuarios", listaUsuarios);

        // Listar tipos de usuario
        List<TipoUsuario> listaTipos = tipoUsuarioService.findAll();
        model.addAttribute("tipoUsuarios", listaTipos);

        // Objeto para el formulario
        model.addAttribute("nuevoUsuario", new Usuario());

        return "usuario"; // Nombre de la plantilla Thymeleaf
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public String save(@ModelAttribute("nuevoUsuario") Usuario usuario) {
        // Encriptar la contraseña en texto plano antes de guardar
        String passwordPlano = usuario.getContrasenya();
        String passwordEncriptado = passwordEncoder.encode(passwordPlano);
        usuario.setContrasenya(passwordEncriptado);

        // Asigna por defecto tipousuario si es nulo (por ejemplo, el ID 2 para "USER")
        if (usuario.getTipousuario() == null) {
            usuario.setTipousuario(4L);
        }

        // Asigna por defecto "activo" si es nulo (por ejemplo, "1")
        if (usuario.getActivo() == null) {
            usuario.setActivo("1");
        }

        // Guardamos el usuario usando la instancia inyectada
        usuarioService.save(usuario);
        return "redirect:/usuario";
    }


    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return "redirect:/usuario";
    }
}
