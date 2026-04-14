package org.example;

import java.sql.SQLOutput;

public class ProdutoEletronico extends Produto {
    private double desconto = 0.10;

    public ProdutoEletronico(String nome, double preco, double desconto) {
        super(nome, preco);
        this.desconto = desconto;
    }

    @Override
    public void calcularPrecoFinal (double preco) {
        double precoComDesconto = preco *(1-desconto);
        if(preco > 0) {
            System.out.println("O produto " + nome);
            System.out.println("O preço sem desconto é: " + preco);
            System.out.println("O desconto aplicado é: " + desconto);
            System.out.println("O preço com desconto é: " + precoComDesconto);
        } else {
            System.out.println("Produto ou preço não encontrado");
        }
    }
}
