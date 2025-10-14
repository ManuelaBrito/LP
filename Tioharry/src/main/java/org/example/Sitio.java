package org.example;

public class Sitio {

    private String tamanho;
    private String duende;
    private String cogumelo;


    public Sitio(String tamanho, String duende, String cogumelo) {
        this.tamanho = tamanho;
        this.duende = duende;
        this.cogumelo = cogumelo;
    }


    public void morar() {
        System.out.println("O Sitio está morando em seu habitat!");
    }


    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDuende() {
        return duende;
    }

    public void setDuende(String duende) {
        this.duende = duende;
    }

    public String getCogumelo() {
        return cogumelo;
    }

    public void setCogumelo(String cogumelo) {
        this.cogumelo = cogumelo;
    }
}
