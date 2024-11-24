package com.clinica.vet.core.repositories;

import com.clinica.vet.core.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
