package org.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Criar a lista (polimorfismo!)
        ArrayList<ItemBiblioteca> itens = new ArrayList<>();

        // Adicionar livros
        itens.add(new Livro("Dom Casmurro", 101, "Machado de Assis"));
        itens.add(new Livro("Java POO", 102, "José Silva"));

        // Adicionar DVDs
        itens.add(new DVD("Inception", 201, 148));
        itens.add(new DVD("Matrix", 202, 136));

        // Adicionar Revistas
        itens.add(new Revista("Veja", 301, 2456));
        itens.add(new Revista("Superinteressante", 302, 189));

        // Array com dias de atraso para cada item
        int[] diasAtraso = {10, 2, 12, 4, 5, 1};

        // Percorrer a lista (polimorfismo!)
        for (int i = 0; i < itens.size(); i++) {
            ItemBiblioteca item = itens.get(i);
            int atraso = diasAtraso[i];

            System.out.println("\n--- Item " + (i+1) + " ---");
            item.exibirDetalhes();
            System.out.println("Dias de atraso: " + atraso);

            double multa = item.calcularMulta(atraso);
            System.out.printf("Multa: R$ %.2f\n", multa);
            System.out.println("Prazo máximo: " + item.getPrazoMaximo() + " dias");
        }
    }
}