package org.example;

public class CartaoDeCredito implements Pagavel {
    private String numeroCartao;
    private String nomeTitular;
    private String validade;

    public CartaoDeCredito(String numeroCartao, String nomeTitular, String validade) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("=== PAGAMENTO COM CARTÃO DE CRÉDITO ===");
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Cartão: **** **** **** " + numeroCartao.substring(numeroCartao.length() - 4));
        System.out.println("Validade: " + validade);
        System.out.println(String.format("Valor: R$ %.2f", valor));
        System.out.println("Status: Pagamento aprovado!");
        System.out.println("----------------------------------------");
    }
}
