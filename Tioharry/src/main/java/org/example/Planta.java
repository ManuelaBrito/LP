package org.example;

public class Planta {

    private String tamanho;
    private String cor;
    private String especie;


    public Planta(String tamanho, String cor, String especie) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.especie = especie;
    }


    public void arborizar() {
        System.out.println("A planta está arborizando o ambiente!");
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
