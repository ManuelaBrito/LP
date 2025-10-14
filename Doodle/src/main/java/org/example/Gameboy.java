package org.example;

public class Gameboy {

    private String cor;
    private String composicao;
    private String marca;


    public Gameboy(String cor, String composicao, String marca) {
        this.cor = cor;
        this.composicao = composicao;
        this.marca = marca;
    }


    public void acaoPrincipal() {
        System.out.println("O Gameboy está entretendo, permitindo jogar e animar!");
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
