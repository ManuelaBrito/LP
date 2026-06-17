package org.example.carga;

public abstract class Carga {
    protected double distancia;
    protected double taxa;

    public Carga(double distancia, double taxa) {
        this.distancia = distancia;
        this.taxa = taxa;

    }
    public void validarDistancia() {
        if (distancia < 10 || distancia > 2000) {
            throw new IllegalArgumentException("Distância inválida");
        }
    }
    public abstract double calcularBase();
}
