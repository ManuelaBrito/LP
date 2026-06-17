package org.example.desconto;

public class DescontoNovo implements PoliticaDesconto {

    @Override
    public double aplicar(double valorComImposto, String PerfilCliente, double valorBase) {
        return 0;
    }
}
