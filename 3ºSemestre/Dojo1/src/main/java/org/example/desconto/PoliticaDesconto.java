package org.example.desconto;

public interface PoliticaDesconto {
    public double aplicar(double valorComImposto, String PerfilCliente, double valorBase);
}
