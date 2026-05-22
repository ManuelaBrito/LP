package org.example.apicollection.Service;

import org.example.apicollection.DTO.PrecipitacaoDTO;
import org.example.apicollection.Model.Precipitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PrecipitacaoService {

    @Autowired
    private LeitorService leitorCSVService;

    private List<Precipitacao> getDados() {
        return leitorCSVService.getDados();
    }

    // Total de precipitação para cada mês do ano
    public Map<YearMonth, Double> totalPorMes() {
        return getDados().stream()
                .collect(Collectors.groupingBy(
                        p -> YearMonth.from(p.getData()),
                        Collectors.summingDouble(Precipitacao::getPrecipitacaoMm)
                ));
    }

    // Total para um mês específico (ano e mês como parâmetros)
    public Double totalPorMes(int ano, int mes) {
        YearMonth ym = YearMonth.of(ano, mes);
        return getDados().stream()
                .filter(p -> YearMonth.from(p.getData()).equals(ym))
                .mapToDouble(Precipitacao::getPrecipitacaoMm)
                .sum();
    }

    // Dia de maior precipitação
    public PrecipitacaoDTO diaMaiorPrecipitacao() {
        return getDados().stream()
                .max(Comparator.comparingDouble(Precipitacao::getPrecipitacaoMm))
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Dia de menor precipitação
    public PrecipitacaoDTO diaMenorPrecipitacao() {
        return getDados().stream()
                .min(Comparator.comparingDouble(Precipitacao::getPrecipitacaoMm))
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Mês de maior precipitação
    public YearMonth mesMaiorPrecipitacao() {
        return totalPorMes().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Mês de menor precipitação
    public YearMonth mesMenorPrecipitacao() {
        return totalPorMes().entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Média anual
    public Double mediaAnual() {
        return getDados().stream()
                .mapToDouble(Precipitacao::getPrecipitacaoMm)
                .average()
                .orElse(0.0);
    }

    // Média por mês
    public Map<YearMonth, Double> mediaPorMes() {
        Map<YearMonth, Double> somaPorMes = totalPorMes();
        Map<YearMonth, Long> diasPorMes = getDados().stream()
                .collect(Collectors.groupingBy(
                        p -> YearMonth.from(p.getData()),
                        Collectors.counting()
                ));

        Map<YearMonth, Double> mediaPorMes = new HashMap<>();
        for (YearMonth ym : somaPorMes.keySet()) {
            double soma = somaPorMes.get(ym);
            long dias = diasPorMes.get(ym);
            mediaPorMes.put(ym, soma / dias);
        }
        return mediaPorMes;
    }

    // Média de um mês específico
    public Double mediaPorMes(int ano, int mes) {
        YearMonth ym = YearMonth.of(ano, mes);
        var precipitacoes = getDados().stream()
                .filter(p -> YearMonth.from(p.getData()).equals(ym))
                .collect(Collectors.toList());

        return precipitacoes.stream()
                .mapToDouble(Precipitacao::getPrecipitacaoMm)
                .average()
                .orElse(0.0);
    }

    // Top 10 dias de maior precipitação
    public List<PrecipitacaoDTO> top10MaioresPrecipitacoes() {
        return getDados().stream()
                .sorted(Comparator.comparingDouble(Precipitacao::getPrecipitacaoMm).reversed())
                .limit(10)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar precipitação por data
    public PrecipitacaoDTO buscarPorData(LocalDate data) {
        return getDados().stream()
                .filter(p -> p.getData().equals(data))
                .findFirst()
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Buscar precipitações por período
    public List<PrecipitacaoDTO> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return getDados().stream()
                .filter(p -> !p.getData().isBefore(inicio) && !p.getData().isAfter(fim))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PrecipitacaoDTO convertToDTO(Precipitacao p) {
        return new PrecipitacaoDTO(p.getData(), p.getPrecipitacaoMm());
    }
}