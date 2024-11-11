package com.clinica.vet.config;

import com.clinica.vet.entities.Funcionario;
import com.clinica.vet.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {
        @Autowired
        private FuncionarioRepository funcionarioRepository;


    @Override
    public void run(String... args) throws Exception {

        Funcionario f1 = new Funcionario(null, "nome", "aa", "aaa", "aaa");
        

    }
}
