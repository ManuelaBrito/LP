package org.example.carga;

public class CargaNormal extends Carga {

    public CargaNormal(double distancia) {
        super(distancia,5.00);
    }
    @Override
    public double calcularBase() {
        double calcularBase = distancia * taxa;
        return calcularBase;
    }
}
