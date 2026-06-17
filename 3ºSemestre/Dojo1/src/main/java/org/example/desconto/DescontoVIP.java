package org.example.desconto;

public class DescontoVIP implements PoliticaDesconto {


    @Override
    public double aplicar(double valorComImposto, String PerfilCliente, double valorBase) {
        return valorComImposto * 0.10;
    }
}
