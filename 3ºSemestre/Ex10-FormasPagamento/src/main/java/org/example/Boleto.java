package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Boleto implements Pagavel {
    private String codigoBarras;
    private LocalDate dataVencimento;

    public Boleto(String codigoBarras, LocalDate dataVencimento) {
        this.codigoBarras = codigoBarras;
        this.dataVencimento = dataVencimento;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("=== PAGAMENTO COM BOLETO ===");
        System.out.println("Código de barras: " + codigoBarras);
        System.out.println("Vencimento: " + dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(String.format("Valor: R$ %.2f", valor));

        if (dataVencimento.isBefore(LocalDate.now())) {
            System.out.println("Status: Pagamento com multa (boleto vencido)!");
        } else {
            System.out.println("Status: Pagamento confirmado!");
        }
        System.out.println("----------------------------------------");
    }
}
