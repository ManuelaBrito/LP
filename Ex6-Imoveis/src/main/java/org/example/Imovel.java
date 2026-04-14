package org.example;

public abstract class Imovel {
    protected String endereco;
    protected double preco;

    public Imovel(String endereco, double preco){
        this.endereco = endereco;
        this.preco = preco;
    }

    public abstract void imprimirPreco(double preco);

    public double getPreco() {
        return preco;
    }
}
