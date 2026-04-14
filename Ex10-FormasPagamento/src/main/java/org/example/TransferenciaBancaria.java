package org.example;

public class TransferenciaBancaria implements Pagavel {
    private String bancoOrigem;
    private String agenciaOrigem;
    private String contaOrigem;
    private String bancoDestino;
    private String agenciaDestino;
    private String contaDestino;

    public TransferenciaBancaria(String bancoOrigem, String agenciaOrigem, String contaOrigem,
                                 String bancoDestino, String agenciaDestino, String contaDestino) {
        this.bancoOrigem = bancoOrigem;
        this.agenciaOrigem = agenciaOrigem;
        this.contaOrigem = contaOrigem;
        this.bancoDestino = bancoDestino;
        this.agenciaDestino = agenciaDestino;
        this.contaDestino = contaDestino;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("=== TRANSFERÊNCIA BANCÁRIA ===");
        System.out.println("Conta de origem:");
        System.out.println("  Banco: " + bancoOrigem);
        System.out.println("  Agência: " + agenciaOrigem);
        System.out.println("  Conta: " + contaOrigem);
        System.out.println("Conta de destino:");
        System.out.println("  Banco: " + bancoDestino);
        System.out.println("  Agência: " + agenciaDestino);
        System.out.println("  Conta: " + contaDestino);
        System.out.println(String.format("Valor transferido: R$ %.2f", valor));
        System.out.println("Status: Transferência realizada com sucesso!");
        System.out.println("----------------------------------------");
    }
}
