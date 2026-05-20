package org.example;

public class Caminhao extends Veiculo{

    public Caminhao(double velocidade) {
        super(velocidade);
    }

    @Override
    public void acelerar(double acelerar){
        System.out.println("A velocidade do caminhão é: " + velocidade + " KM/h");
    }
}
