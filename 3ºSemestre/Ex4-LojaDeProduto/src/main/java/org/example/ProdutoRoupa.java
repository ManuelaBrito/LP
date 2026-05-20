package org.example;

public class ProdutoRoupa extends Produto {
    private double desconto2 = 0.20;

    public ProdutoRoupa(String nome, double preco, double desconto2) {
        super(nome, preco);
        this.desconto2 = desconto2;
    }

    @Override
    public void calcularPrecoFinal(double preco) {
        double precoComDesconto2 = preco * (1-desconto2);
        if(preco > 0) {
            System.out.println("O produto " + nome);
            System.out.println("O preço é: " + preco);
            System.out.println("O desconto é: " + desconto2);
            System.out.println("O preço com desconto é: " + precoComDesconto2);
        }
    }
}
