package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Yvan");
        usuario.setApellido("Lopez");
        usuario.setEmail("yvan@mail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        return "perfil";

    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", textoListar);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        return Arrays.asList(
            new Usuario("yvan", "lopez", "yvan@mail.com"),
            new Usuario("benji", "lopez", "benji@mail.com"),
            new Usuario("fausto", "lopez", "fausto@mail.com"),
            new Usuario("maritza", "lopez", "maritza@mail.com")
        );
    }

}
