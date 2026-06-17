package org.example.carga;

public class CargaPerigosa extends Carga {
    private static final int ADICIONAL = 150;

    public CargaPerigosa(double distancia) {
        super(distancia, 12.00);
    }
    @Override
    public double calcularBase() {
        double calcular = distancia * taxa;
        return calcular + ADICIONAL;
    }

}
