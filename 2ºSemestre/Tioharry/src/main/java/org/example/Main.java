package org.example;

public class Main {
    public static void main(String[] args) {

        Sitio silio1 = new Sitio("Pequeno", "Duende verde", "Cogumelo mágico");
        Planta planta1 = new Planta("Média", "Verde", "Samambaia");
        Quintal quintal1 = new Quintal("Carvalho", "Cascavel do campo", "Rosa");


        System.out.println("=== SITIO ===");
        System.out.println("Tamanho: " + silio1.getTamanho());
        System.out.println("Duende: " + silio1.getDuende());
        System.out.println("Cogumelo: " + silio1.getCogumelo());
        silio1.morar();

        System.out.println("\n=== PLANTA ===");
        System.out.println("Tamanho: " + planta1.getTamanho());
        System.out.println("Cor: " + planta1.getCor());
        System.out.println("Espécie: " + planta1.getEspecie());
        planta1.arborizar();

        System.out.println("\n=== QUINAL ===");
        System.out.println("Árvore: " + quintal1.getArvore());
        System.out.println("Cascavel: " + quintal1.getCascavel());
        System.out.println("Planta: " + quintal1.getPlanta());
        quintal1.plantar();

        // Demonstração de interação
        System.out.println("\n=== ECOSSISTEMA COMPLETO ===");
        System.out.println("No ecossistema temos:");
        silio1.morar();
        planta1.arborizar();
        quintal1.plantar();
    }
}