package org.example;

public class Carro extends Veiculo {

    public Carro(double velocidade){
        super(velocidade);
    }

    @Override
    public void acelerar(double velocidade){
        System.out.println("A velocidade do carro é: " + velocidade + " KM/h");
    }
}
