package org.example;

public abstract class Veiculo {
    protected double velocidade;

    public Veiculo(double velocidade){
        this.velocidade=velocidade;
    }

    public abstract void acelerar(double velocidade);

    public double getVelocidade() {
        return velocidade;
    }
}
