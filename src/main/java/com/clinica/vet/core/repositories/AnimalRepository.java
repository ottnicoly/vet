package com.clinica.vet.core.repositories;

import com.clinica.vet.core.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
