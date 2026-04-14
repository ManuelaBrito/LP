package org.example;

public class App {
    public static void main(String[] args) {
        ProdutoEletronico celular = new ProdutoEletronico("iPhone", 3000.00, 0.10);
        ProdutoRoupa camiseta = new ProdutoRoupa("Camiseta básica", 100.00,0.20);
        ProdutoLivro duna = new ProdutoLivro("Duna: O messias", 43.00);

        celular.calcularPrecoFinal(3000.00);
        camiseta.calcularPrecoFinal(100.00);
        duna.calcularPrecoFinal(43.00);
    }
}