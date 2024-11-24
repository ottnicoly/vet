package com.clinica.vet.controllers.web;

import com.clinica.vet.core.entities.Animal;
import com.clinica.vet.core.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("animal");
        mv.addObject("lista", service.findAll());
        mv.addObject("elemento", new Animal());
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute("elemento") Animal animal){
        try {
            service.save(animal);
            return new ModelAndView("redirect:/animais");
        } catch (Exception e) {
            var mv = new ModelAndView("animal");
            mv.addObject("elemento",animal);
            return mv;
        }
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable long id) {
        var opt = service.findById(id);
        if(opt.isPresent()) {
            service.delete(opt.get());
        }
        return new ModelAndView("redirect:/animais");
    }


}
