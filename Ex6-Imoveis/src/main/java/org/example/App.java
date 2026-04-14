package org.example;

public class App {
    public static void main(String[] args) {
        Novo apartamento = new Novo("Rua Marechal",500000.00,0.30);
        Velho duplex = new Velho("Rua Dominic",800000.00,0.20);

        duplex.imprimirPreco(800000.00);
        apartamento.imprimirPreco(500000.00);

    }

}