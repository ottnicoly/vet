package com.clinica.vet.config;

import com.clinica.vet.core.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public void run(String... args) throws Exception {

//        Funcionario f1 = new Funcionario(null, "Ian", "000.000.000-00", "ian@gmail.com", "Recepcionista");
//        Funcionario f2 = new Funcionario(null, "Nicoly", "000.000.000-00", "nicoly@gmail.com", "Recepcionista");

//        funcionarioRepository.save(f1);
//        funcionarioRepository.save(f2);
    }
}
