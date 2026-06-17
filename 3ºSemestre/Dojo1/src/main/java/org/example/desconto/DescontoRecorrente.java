package org.example.desconto;

public class DescontoRecorrente implements PoliticaDesconto {

    @Override
    public double aplicar(double valorComImposto, String perfilCliente, double valorBase) {
        return (valorComImposto > 500) ? valorComImposto * 0.05 : 0;
        }
    }


