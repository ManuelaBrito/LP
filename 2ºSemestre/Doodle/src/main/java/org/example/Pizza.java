package org.example;

public class Pizza {

    private String sabor;
    private String tamanho;
    private String temperatura;


    public Pizza(String sabor, String tamanho, String temperatura) {
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.temperatura = temperatura;
    }


    public void acaoPrincipal() {
        System.out.println("A pizza está alimentando, saciando e pode ser assada!");
    }


    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
