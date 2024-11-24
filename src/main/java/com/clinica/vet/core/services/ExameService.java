package com.clinica.vet.core.services;


import com.clinica.vet.core.entities.Consulta;
import com.clinica.vet.core.entities.Exame;
import com.clinica.vet.core.repositories.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExameService {

    @Autowired
    private ExameRepository repository;

    public List<Exame> findAll() {
        return repository.findAll();
    }

    public Optional<Exame> findById(Long id){
        return repository.findById(id);
    }

    public void save(Exame exame) {
        repository.save(exame);
    }

    public void delete(Exame exame){
        repository.delete(exame);
    }


}
