package org.example;

public class Main {
    public static void main(String[] args) {

        Pizza pizza1 = new Pizza("Calabresa", "Grande", "Quente");
        Predio predio1 = new Predio(50.5, "Cinza", "Centro");
        Gameboy gameboy1 = new Gameboy("Cinza", "Plástico", "Nintendo");


        System.out.println("=== PIZZA ===");
        System.out.println("Sabor: " + pizza1.getSabor());
        System.out.println("Tamanho: " + pizza1.getTamanho());
        System.out.println("Temperatura: " + pizza1.getTemperatura());
        pizza1.acaoPrincipal();

        System.out.println("\n=== PRÉDIO ===");
        System.out.println("Altura: " + predio1.getAltura() + " metros");
        System.out.println("Cor: " + predio1.getCor());
        System.out.println("Posição: " + predio1.getPosicao());
        predio1.acaoPrincipal();

        System.out.println("\n=== GAMEBOY ===");
        System.out.println("Cor: " + gameboy1.getCor());
        System.out.println("Composição: " + gameboy1.getComposicao());
        System.out.println("Marca: " + gameboy1.getMarca());
        gameboy1.acaoPrincipal();
    }
}