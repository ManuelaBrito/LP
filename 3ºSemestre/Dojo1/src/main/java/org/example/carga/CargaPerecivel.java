package org.example.carga;

public class CargaPerecivel extends Carga {
    private static final double horaEstrada = 2.00;
    private static final int quilometragem = 80;

    public CargaPerecivel (double distancia) {
        super(distancia,8.00);
    }
    public double adicionalHora(){
        double horasViagem = (distancia / quilometragem);
        double addHora = horasViagem * horaEstrada;
        return addHora;
    }
    @Override
    public double calcularBase() {
        double calcularBase;
        calcularBase = (distancia * taxa) + adicionalHora();
        return calcularBase;
    }
}
