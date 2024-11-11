package com.clinica.vet.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_animal")
public class Animal {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String raca;

}
