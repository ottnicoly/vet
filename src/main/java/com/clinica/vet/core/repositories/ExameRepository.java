package com.clinica.vet.core.repositories;

import com.clinica.vet.core.entities.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    List<Exame> findByData(LocalDate data);

    @Query("SELECT FUNCTION('MONTH', e.data) AS mes, COUNT(e) AS quantidade FROM Exame e GROUP BY FUNCTION('MONTH', e.data)")
    List<Object[]> countExamesPorMes();
}
