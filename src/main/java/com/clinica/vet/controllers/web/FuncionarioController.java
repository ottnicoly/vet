package com.clinica.vet.controllers.web;

import com.clinica.vet.core.entities.Funcionario;
import com.clinica.vet.core.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("funcionario");
        mv.addObject("lista", service.findAll());
        mv.addObject("elemento", new Funcionario());
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute("elemento") Funcionario funcionario){
        try {
            service.save(funcionario);
            return new ModelAndView("redirect:/funcionarios");
        } catch (Exception e) {
            var mv = new ModelAndView("funcionario");
            mv.addObject("elemento",funcionario);
            return mv;
        }
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable long id) {
        var opt = service.findById(id);
        if(opt.isPresent()) {
            service.delete(opt.get());
        }
        return new ModelAndView("redirect:/funcionarios");
    }
}
