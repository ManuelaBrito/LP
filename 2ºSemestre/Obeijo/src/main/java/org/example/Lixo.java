package org.example;

public class Lixo {

    private String pneu;
    private String plastico;
    private String garrafa;


    public Lixo(String pneu, String plastico, String garrafa) {
        this.pneu = pneu;
        this.plastico = plastico;
        this.garrafa = garrafa;
    }


    public void ilustrar() {
        System.out.println("O lixo está ilustrando uma cena!");
    }

    public String getPneu() {
        return pneu;
    }

    public void setPneu(String pneu) {
        this.pneu = pneu;
    }

    public String getPlastico() {
        return plastico;
    }

    public void setPlastico(String plastico) {
        this.plastico = plastico;
    }

    public String getGarrafa() {
        return garrafa;
    }

    public void setGarrafa(String garrafa) {
        this.garrafa = garrafa;
    }
}
