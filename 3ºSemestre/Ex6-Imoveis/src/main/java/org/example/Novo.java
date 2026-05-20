package org.example;

public class Novo extends Imovel {
    private double valorAdicional = 0.30;

    public Novo (String endereco, double preco, double valorAdicional) {
        super(endereco, preco);
        this.valorAdicional = valorAdicional;
    }

    @Override
    public void imprimirPreco(double preco){
        double precoComValorAdicional = preco * (1 + valorAdicional);
        if(preco > 0) {
            System.out.println("O preço base do imóvel é: " + preco);
            System.out.println("O preço desse Imóvel novo é: " + precoComValorAdicional);
        }
    }
}
