package org.example;

public class Velho extends Imovel{
    private double desconto = 0.20;

    public Velho(String endereco, double preco, double desconto){
        super(endereco, preco);
        this.desconto=desconto;
    }

    @Override
    public void imprimirPreco(double preco) {
        double precoComDesconto = preco * (1 - desconto);
        if(preco > 0) {
            System.out.println("Preço base: " + preco);
            System.out.println("O preço com desconto é: " + precoComDesconto);
        }
    }
}
