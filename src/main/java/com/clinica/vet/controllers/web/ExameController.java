package com.clinica.vet.controllers.web;


import com.clinica.vet.core.entities.Exame;
import com.clinica.vet.core.services.AnimalService;
import com.clinica.vet.core.services.ExameService;
import com.clinica.vet.core.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    private ExameService service;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("exame");
        mv.addObject("lista", service.findAll());
        mv.addObject("funcionarios", funcionarioService.findAll());
        mv.addObject("animais", animalService.findAll());
        mv.addObject("elemento", new Exame());
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@RequestParam("animalId") Long animalId ,@RequestParam("funcionarioId") Long funcionarioId, @ModelAttribute("elemento") Exame exame){
        try {

            var funcionario = funcionarioService.findById(funcionarioId)
                            .orElseThrow(() -> new Exception("Funcionario não encontrado"));

            var animal = animalService.findById(animalId)
                            .orElseThrow(() -> new Exception("Animal não encontrado"));

            exame.setFuncionario(funcionario);
            exame.setAnimal(animal);

            service.save(exame);
            return new ModelAndView("redirect:/exames");
        } catch (Exception e) {
            var mv = new ModelAndView("exame");
            mv.addObject("elemento", exame);
            mv.addObject("funcionarios", funcionarioService.findAll());
            mv.addObject("animais", animalService.findAll());
            return mv;
        }
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable long id) {
        var opt = service.findById(id);
        if(opt.isPresent()){
            service.delete(opt.get());
        }
        return new ModelAndView("redirect:/exames");
    }

    @GetMapping("/exames")
    public ModelAndView index(@RequestParam(value = "dataFiltro", required = false) String dataFiltro) {
        var mv = new ModelAndView("exame");

        List<Exame> exames;
        if (dataFiltro != null && !dataFiltro.isEmpty()) {
            // Converte a String para LocalDate
            LocalDate data = LocalDate.parse(dataFiltro);
            // Filtra os exames pela data recebida
            exames = service.findByData(data);
        } else {
            exames = service.findAll();
        }

        mv.addObject("lista", exames);
        mv.addObject("funcionarios", funcionarioService.findAll());
        mv.addObject("animais", animalService.findAll());
        mv.addObject("elemento", new Exame());
        return mv;
    }

}
