package org.example.apicollection.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticasResponseDTO {
    private Map<YearMonth, Double> totalPorMes;
    private Map<YearMonth, Double> mediaPorMes;
    private PrecipitacaoDTO diaMaiorPrecipitacao;
    private PrecipitacaoDTO diaMenorPrecipitacao;
    private YearMonth mesMaiorPrecipitacao;
    private YearMonth mesMenorPrecipitacao;
    private Double mediaAnual;
    private List<PrecipitacaoDTO> top10MaioresPrecipitacoes;
}