package org.example;

public class Homem {
    private String tamanho;
    private String cor;
    private String posicao;


    public Homem(String tamanho, String cor, String posicao) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.posicao = posicao;
    }


    public void amar() {
        System.out.println("O homem está amando!");
    }


    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
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