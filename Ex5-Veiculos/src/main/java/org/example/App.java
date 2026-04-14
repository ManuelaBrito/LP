
package org.example;

public class App {

    public static void testarAceleracao(Veiculo veiculo, double velocidade) {
        veiculo.acelerar(velocidade);
    }

    public static void main(String[] args) {
        Carro corola = new Carro(60);
        Moto honda = new Moto(180);
        Caminhao truck = new Caminhao(40);


        corola.acelerar(60);
        honda.acelerar(180);
        truck.acelerar(40);

        testarAceleracao(corola, 100);
        testarAceleracao(honda, 200);
        testarAceleracao(truck, 80);

        Veiculo[] veiculos = {corola, honda, truck};

        for (Veiculo v : veiculos) {
            v.acelerar(120);
        }
    }
}