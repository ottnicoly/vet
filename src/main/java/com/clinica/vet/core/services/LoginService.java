package com.clinica.vet.core.services;

import com.clinica.vet.core.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nomeusuario) throws UsernameNotFoundException {
        var opt = repository.findByEmailAndAtivoTrue(nomeusuario);
        if(opt.isEmpty()) {throw new UsernameNotFoundException(nomeusuario);}
        var usuario = opt.get();
        return new org.springframework.security.core.userdetails.User(
                usuario.getEmail(),
                usuario.getSenha(),
                new ArrayList<>()
        );
    }
}


