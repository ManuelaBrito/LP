package org.example.imposto;

public class ImpostoMG implements CalculadorDeImposto{

    @Override
    public double calcular(double valorBase, String estado) {
        return valorBase * 0.12 ;
    }
}
