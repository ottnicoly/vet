package com.clinica.vet.core.repositories;

import com.clinica.vet.core.entities.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<Exame, Long> {
}
