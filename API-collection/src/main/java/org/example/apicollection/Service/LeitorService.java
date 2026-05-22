package org.example.apicollection.Service;

import org.example.apicollection.Model.Precipitacao;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeitorService {

    @Value("classpath:precipitacao_2025.csv")
    private Resource csvFile;

    private List<Precipitacao> dados;

    @PostConstruct
    public void carregarDados() {
        dados = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            if (!csvFile.exists()) {
                System.err.println("Arquivo CSV não encontrado: " + csvFile.getFilename());
                criarDadosExemplo();
                return;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(csvFile.getInputStream()))) {
                String linha;
                boolean primeiraLinha = true;
                int linhasProcessadas = 0;

                while ((linha = br.readLine()) != null) {
                    if (primeiraLinha) {
                        primeiraLinha = false;
                        continue; // pular cabeçalho
                    }

                    if (linha.trim().isEmpty()) {
                        continue;
                    }

                    // Formato: id;valor;data;posto
                    String[] partes = linha.split(";");
                    if (partes.length >= 3) {
                        try {
                            // A coluna "valor" é a precipitação
                            Double precipitacao = Double.parseDouble(partes[1].trim());
                            LocalDate data = LocalDate.parse(partes[2].trim(), formatter);

                            // Filtrar apenas dados do posto 2 (conforme seu arquivo)
                            // Se quiser todos os postos, remova esta verificação
                            if (partes.length >= 4 && "2".equals(partes[3].trim())) {
                                dados.add(new Precipitacao(data, precipitacao));
                                linhasProcessadas++;
                            }
                        } catch (Exception e) {
                            System.err.println("Erro ao processar linha: " + linha + " - " + e.getMessage());
                        }
                    }
                }
            }

            System.out.println("Carregados " + dados.size() + " registros de precipitação do posto 2");

            if (dados.isEmpty()) {
                criarDadosExemplo();
            }

        } catch (Exception e) {
            System.err.println("Erro ao carregar arquivo CSV: " + e.getMessage());
            criarDadosExemplo();
        }
    }

    private void criarDadosExemplo() {
        System.out.println("Criando dados de exemplo para teste...");
        dados = new ArrayList<>();

        // Adicionar alguns dados do seu arquivo como exemplo
        dados.add(new Precipitacao(LocalDate.of(2025, 1, 15), 192.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 1, 16), 45.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 1, 20), 46.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 1, 25), 65.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 2, 14), 72.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 3, 9), 69.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 3, 15), 45.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 4, 19), 55.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 5, 11), 32.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 7, 1), 22.0));
        dados.add(new Precipitacao(LocalDate.of(2025, 7, 2), 15.0));
    }

    public List<Precipitacao> getDados() {
        return new ArrayList<>(dados);
    }

    public boolean temDados() {
        return !dados.isEmpty();
    }
}