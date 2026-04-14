package org.example;

public class Mulher {

    private String altura;
    private String cor;
    private String posicao;


    public Mulher(String altura, String cor, String posicao) {
        this.altura = altura;
        this.cor = cor;
        this.posicao = posicao;
    }


    public void beijar() {
        System.out.println("A mulher está beijando!");
    }


    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
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
