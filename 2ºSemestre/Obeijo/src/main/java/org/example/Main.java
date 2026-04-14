package org.example;

public class Main {
    public static void main(String[] args) {

        Homem homem1 = new Homem("Médio", "Branco", "Em pé");
        Mulher mulher1 = new Mulher("1.70m", "Morena", "Sentada");
        Lixo lixo1 = new Lixo("Pneu velho", "Garrafa PET", "Vidro quebrado");


        System.out.println("=== HOMEM ===");
        System.out.println("Tamanho: " + homem1.getTamanho());
        System.out.println("Cor: " + homem1.getCor());
        System.out.println("Posição: " + homem1.getPosicao());
        homem1.amar();

        System.out.println("\n=== MULHER ===");
        System.out.println("Altura: " + mulher1.getAltura());
        System.out.println("Cor: " + mulher1.getCor());
        System.out.println("Posição: " + mulher1.getPosicao());
        mulher1.beijar();

        System.out.println("\n=== LIXO ===");
        System.out.println("Pneu: " + lixo1.getPneu());
        System.out.println("Plástico: " + lixo1.getPlastico());
        System.out.println("Garrafa: " + lixo1.getGarrafa());
        lixo1.ilustrar();

        // Demonstração de interação
        System.out.println("\n=== CENA COMPLETA ===");
        System.out.println("Na cena temos:");
        homem1.amar();
        mulher1.beijar();
        lixo1.ilustrar();
    }
}