package org.example;

public class ProdutoLivro extends Produto {

    public ProdutoLivro(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public void calcularPrecoFinal(double preco) {
        System.out.println("O produto " + nome);
        System.out.println("Esse produto está ilegível para desconto");
        System.out.println("O preço é: " + preco);
    }
}
