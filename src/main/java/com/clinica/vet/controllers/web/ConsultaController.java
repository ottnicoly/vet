package com.clinica.vet.controllers.web;

import com.clinica.vet.core.entities.Consulta;
import com.clinica.vet.core.services.AnimalService;
import com.clinica.vet.core.services.ConsultaService;
import com.clinica.vet.core.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("consulta");
        mv.addObject("lista", service.findAll());
        mv.addObject("funcionarios", funcionarioService.findAll());
        mv.addObject("animais", animalService.findAll());
        mv.addObject("elemento", new Consulta());
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@RequestParam("animalId") Long animalId ,@RequestParam("funcionarioId") Long funcionarioId,@ModelAttribute("elemento") Consulta consulta){
        try {

            var funcionario = funcionarioService.findById(funcionarioId)
                    .orElseThrow(() -> new Exception("Funcionario não encontrado"));

            var animal = animalService.findById(animalId)
                    .orElseThrow(() -> new Exception("Animal não encontrado"));

            consulta.setFuncionario(funcionario);
            consulta.setAnimal(animal);

            service.save(consulta);
            return new ModelAndView("redirect:/consultas");
        } catch (Exception e) {
            var mv = new ModelAndView("consulta");
            mv.addObject("elemento",consulta);
            mv.addObject("funcionarios", funcionarioService.findAll());
            mv.addObject("animais", animalService.findAll());
            return mv;
        }
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable long id) {
        var opt = service.findById(id);
        if(opt.isPresent()) {
            service.delete(opt.get());
        }
        return new ModelAndView("redirect:/consultas");
    }

}
