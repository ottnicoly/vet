package com.clinica.vet.core.services;

import com.clinica.vet.core.dto.GraficoDTO;
import com.clinica.vet.core.repositories.ConsultaRepository;
import com.clinica.vet.core.repositories.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraficoService {

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public GraficoDTO grafico() {
        // Criação do DTO
        var dto = new GraficoDTO();
        dto.setTitulo("Quantidade de Exames por Mês");
        dto.setLegenda("Total de exames realizados por mês");
        dto.setXLabel("Mês");

        // Obtendo os dados do banco de dados
        List<Object[]> resultadoExame = exameRepository.countExamesPorMes();

        // Preparando os dados para o gráfico
        List<String> labels = new ArrayList<>();
        List<String> valores = new ArrayList<>();

        for (Object[] obj : resultadoExame) {
            Integer mes = (Integer) obj[0];
            Long quantidade = (Long) obj[1];

            // Convertendo o número do mês para o nome do mês
            String mesNome = getNomeMes(mes);
            labels.add(mesNome);
            valores.add(String.valueOf(quantidade));
        }
        return dto;
    }

    private String getNomeMes(Integer mes) {
        // Converte o número do mês para o nome correspondente
        switch (mes) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                return "Unknown";
        }
    }
}
