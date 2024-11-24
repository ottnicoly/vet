package com.clinica.vet.controllers.web;

import com.clinica.vet.core.entities.Cliente;
import com.clinica.vet.core.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("cliente");
        mv.addObject("lista", service.findAll());
        mv.addObject("elemento", new Cliente());
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute("elemento") Cliente cliente){
        try {
            service.save(cliente);
            return new ModelAndView("redirect:/clientes");
        } catch (Exception e) {
            var mv = new ModelAndView("cliente");
            mv.addObject("elemento",cliente);
            return mv;
        }
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable long id) {
        var opt = service.findById(id);
        if(opt.isPresent()) {
            service.delete(opt.get());
        }
        return new ModelAndView("redirect:/clientes");
    }

}
