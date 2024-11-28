package com.clinica.vet.core.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
public class GraficoDTO {

    private String titulo;
    private String legenda;
    private String xLabel;
    private String yLabel;
    private List<String> labels;
    private List<String> valores;
    private List<String> cores;
}
