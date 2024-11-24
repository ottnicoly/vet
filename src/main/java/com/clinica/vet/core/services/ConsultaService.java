package com.clinica.vet.core.services;

import com.clinica.vet.core.entities.Consulta;
import com.clinica.vet.core.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository repository;

    public List<Consulta> findAll(){
        return repository.findAll();
    }

    public Optional<Consulta> findById(Long id){
        return repository.findById(id);
    }

    public void save(Consulta consulta) {
        repository.save(consulta);
    }

    public void delete(Consulta consulta){
        repository.delete(consulta);
    }

}
