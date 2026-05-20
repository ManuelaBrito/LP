package org.example;

public class App {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("João Silva", 5000.00, "TI");
        Programador programador = new Programador("Maria Santos", 4000.00, "Java");

        gerente.exibirInformacoes();
        programador.exibirInformacoes();
    }
}