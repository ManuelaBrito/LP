package org.example;

public class Moto extends Veiculo {

    public Moto(double velocidade){
        super(velocidade);
    }

    @Override
    public void acelerar(double velocidade){
        System.out.println("A velocidade da moto é: " + velocidade + " KM/h");
    }
}
