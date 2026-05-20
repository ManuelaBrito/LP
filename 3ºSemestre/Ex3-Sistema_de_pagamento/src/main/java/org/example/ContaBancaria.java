package org.example;

public abstract class ContaBancaria {
    protected double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado. Saldo: R$" + saldo);
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public abstract void sacar(double valor);

    public double getSaldo() {
        return saldo;
    }
}