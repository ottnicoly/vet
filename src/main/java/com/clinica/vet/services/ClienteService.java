package com.clinica.vet.services;

import com.clinica.vet.entities.Cliente;
import com.clinica.vet.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Optional<Cliente> findById(Long id){
        return repository.findById(id);
    }

    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    public void delete(Cliente cliente){
        repository.delete(cliente);
    }



}
