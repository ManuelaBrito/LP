package org.example;

public class ContaCorrente extends ContaBancaria {
    private double taxa = 0.10;

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor * (1 + taxa);

        if (valor > 0 && valorComTaxa <= saldo) {
            saldo -= valorComTaxa;
            System.out.println("=== CONTA CORRENTE ===");
            System.out.println("Valor do saque: R$" + valor);
            System.out.println("Taxa (10%): R$" + (valor * taxa));
            System.out.println("Total debitado: R$" + valorComTaxa);
            System.out.println("Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor + " + taxa!");
        }
    }
}