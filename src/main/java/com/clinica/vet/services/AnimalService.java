package com.clinica.vet.services;

import com.clinica.vet.entities.Animal;
import com.clinica.vet.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository repository;

    public List<Animal> findAll(){
        return repository.findAll();
    }

    public Optional<Animal> findById(Long id){
        return repository.findById(id);
    }

    public void save(Animal animal){
        repository.save(animal);
    }

    public void delete(Animal animal){
        repository.delete(animal);
    }

}
