package org.example.imposto;

public class ImpostoOutros implements CalculadorDeImposto {
    @Override
    public double calcular(double valorBase, String estado) {
        return valorBase * 0.15;
    }
}