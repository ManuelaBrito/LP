package org.example;

public class Quintal {

    private String arvore;
    private String cascavel;
    private String planta;


    public Quintal(String arvore, String cascavel, String planta) {
        this.arvore = arvore;
        this.cascavel = cascavel;
        this.planta = planta;
    }


    public void plantar() {
        System.out.println("O Quintal está plantando novas espécies!");
    }


    public String getArvore() {
        return arvore;
    }

    public void setArvore(String arvore) {
        this.arvore = arvore;
    }

    public String getCascavel() {
        return cascavel;
    }

    public void setCascavel(String cascavel) {
        this.cascavel = cascavel;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }
}
