package com.clinica.vet.controllers.web;

import com.clinica.vet.core.dto.GraficoDTO;
import com.clinica.vet.core.services.GraficoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/grafico")
public class GraficoController {

    @Autowired
    private GraficoService service;

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("grafico");
        mv.addObject("grafico", service.grafico());
        return mv;
    }
}
