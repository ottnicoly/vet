package com.clinica.vet.controllers;

import com.clinica.vet.repositories.FuncionarioRepository;
import com.clinica.vet.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ModelAndView index(){
        var mv = new ModelAndView("index");
        mv.addObject("lista",service.findAll());
        return mv;
    }

}
