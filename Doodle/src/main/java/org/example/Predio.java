package org.example;

public class Predio {

    private double altura;
    private String cor;
    private String posicao;


    public Predio(double altura, String cor, String posicao) {
        this.altura = altura;
        this.cor = cor;
        this.posicao = posicao;
    }


    public void acaoPrincipal() {
        System.out.println("O prédio está servindo para morar, alugar e comprar!");
    }


    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
}
