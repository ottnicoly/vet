package com.clinica.vet.services;

import com.clinica.vet.entities.Funcionario;
import com.clinica.vet.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> findAll(){
        return repository.findAll();
    }

    public Optional<Funcionario> findById(Long id){
        return repository.findById(id);
    }

}
