package org.example;

public abstract class Funcionario {
    protected double valor;

    public Funcionario(double valor){
        this.valor=valor;
    }

    public abstract void calcularBonus();
}
