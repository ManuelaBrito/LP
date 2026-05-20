package org.example;

public class ContaPoupanca extends ContaBancaria {
    private double taxaJuros = 0.05;

    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("=== CONTA POUPANÇA ===");
            System.out.println("Saque de R$" + valor + " realizado");
            System.out.println("Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor + "!");
        }
    }

    public void renderJuros() {
        double juros = saldo * taxaJuros;
        saldo += juros;
        System.out.println("=== RENDIMENTO ===");
        System.out.println("Juros de 5%: R$" + juros);
        System.out.println("Saldo atual: R$" + saldo);
    }
}
