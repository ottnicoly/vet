package com.clinica.vet.core.services;

import com.clinica.vet.core.entities.Funcionario;
import com.clinica.vet.core.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    public void save(Funcionario funcionario) {
        // Criptografa a senha ao cadastrar
        if (funcionario.getSenha() != null && !funcionario.getSenha().isEmpty()) {
            String senhaCriptografada = passwordEncoder.encode(funcionario.getSenha());
            funcionario.setSenha(senhaCriptografada);
        }
        repository.save(funcionario);
    }

    public void delete(Funcionario funcionario) {
        repository.delete(funcionario);
    }
}
