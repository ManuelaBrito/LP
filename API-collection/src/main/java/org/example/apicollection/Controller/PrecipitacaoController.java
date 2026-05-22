package org.example.apicollection.Controller;

import org.example.apicollection.DTO.EstatisticasResponseDTO;
import org.example.apicollection.DTO.PrecipitacaoDTO;
import org.example.apicollection.Service.PrecipitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/precipitacao")
@CrossOrigin(origins = "*")
public class PrecipitacaoController {

    @Autowired
    private PrecipitacaoService service;

    // Endpoint para todas as estatísticas
    @GetMapping("/estatisticas")
    public ResponseEntity<EstatisticasResponseDTO> getEstatisticasCompletas() {
        EstatisticasResponseDTO estatisticas = EstatisticasResponseDTO.builder()
                .totalPorMes(service.totalPorMes())
                .mediaPorMes(service.mediaPorMes())
                .diaMaiorPrecipitacao(service.diaMaiorPrecipitacao())
                .diaMenorPrecipitacao(service.diaMenorPrecipitacao())
                .mesMaiorPrecipitacao(service.mesMaiorPrecipitacao())
                .mesMenorPrecipitacao(service.mesMenorPrecipitacao())
                .mediaAnual(service.mediaAnual())
                .top10MaioresPrecipitacoes(service.top10MaioresPrecipitacoes())
                .build();

        return ResponseEntity.ok(estatisticas);
    }

    // Total por mês específico
    @GetMapping("/total/{ano}/{mes}")
    public ResponseEntity<Double> getTotalPorMes(
            @PathVariable int ano,
            @PathVariable int mes) {
        return ResponseEntity.ok(service.totalPorMes(ano, mes));
    }

    // Média por mês específico
    @GetMapping("/media/{ano}/{mes}")
    public ResponseEntity<Double> getMediaPorMes(
            @PathVariable int ano,
            @PathVariable int mes) {
        return ResponseEntity.ok(service.mediaPorMes(ano, mes));
    }

    // Dia de maior precipitação
    @GetMapping("/maior-dia")
    public ResponseEntity<PrecipitacaoDTO> getDiaMaiorPrecipitacao() {
        return ResponseEntity.ok(service.diaMaiorPrecipitacao());
    }

    // Dia de menor precipitação
    @GetMapping("/menor-dia")
    public ResponseEntity<PrecipitacaoDTO> getDiaMenorPrecipitacao() {
        return ResponseEntity.ok(service.diaMenorPrecipitacao());
    }

    // Mês de maior precipitação
    @GetMapping("/maior-mes")
    public ResponseEntity<YearMonth> getMesMaiorPrecipitacao() {
        return ResponseEntity.ok(service.mesMaiorPrecipitacao());
    }

    // Mês de menor precipitação
    @GetMapping("/menor-mes")
    public ResponseEntity<YearMonth> getMesMenorPrecipitacao() {
        return ResponseEntity.ok(service.mesMenorPrecipitacao());
    }

    // Média anual
    @GetMapping("/media-anual")
    public ResponseEntity<Double> getMediaAnual() {
        return ResponseEntity.ok(service.mediaAnual());
    }

    // Top 10 dias
    @GetMapping("/top10")
    public ResponseEntity<List<PrecipitacaoDTO>> getTop10Maiores() {
        return ResponseEntity.ok(service.top10MaioresPrecipitacoes());
    }

    // Buscar por data específica
    @GetMapping("/data/{data}")
    public ResponseEntity<PrecipitacaoDTO> getPorData(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        PrecipitacaoDTO resultado = service.buscarPorData(data);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar por período
    @GetMapping("/periodo")
    public ResponseEntity<List<PrecipitacaoDTO>> getPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
        return ResponseEntity.ok(service.buscarPorPeriodo(inicio, fim));
    }
}