package org.example;

import java.time.LocalDate;

public class App {

    public static void realizarPagamento(Pagavel pagamento, double valor) {
        pagamento.processarPagamento(valor);
    }

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PAGAMENTOS ===\n");

        // Criando diferentes formas de pagamento
        CartaoDeCredito cartao = new CartaoDeCredito(
                "1234 5678 9012 3456",
                "João Silva",
                "12/2028"
        );

        Boleto boleto = new Boleto(
                "12345678901234567890123456789012345678901234",
                LocalDate.of(2024, 12, 15)
        );

        TransferenciaBancaria transferencia = new TransferenciaBancaria(
                "Banco do Brasil",
                "1234-5",
                "12345-6",
                "Nubank",
                "5678-9",
                "98765-4"
        );


        realizarPagamento(cartao, 1500.00);
        realizarPagamento(boleto, 299.90);
        realizarPagamento(transferencia, 5000.00);


        // Criando array de Pagavel
        Pagavel[] pagamentos = {cartao, boleto, transferencia};
        double[] valores = {1500.00, 299.90, 5000.00};

        for (int i = 0; i < pagamentos.length; i++) {
            pagamentos[i].processarPagamento(valores[i]);
        }
    }
}