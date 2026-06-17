package org.example;

import org.example.carga.Carga;
import org.example.carga.CargaNormal;
import org.example.desconto.DescontoVIP;
import org.example.desconto.PoliticaDesconto;
import org.example.frete.Frete;
import org.example.imposto.CalculadorDeImposto;
import org.example.imposto.ImpostoSP;

public class Main {
    public static void main(String[] args) {
        Carga carga = new CargaNormal(100);
        CalculadorDeImposto imposto = new ImpostoSP();
        PoliticaDesconto desconto = new DescontoVIP();
        Frete frete = new Frete(carga, imposto, desconto, "SP", "VIP");
        frete.calcular();
        System.out.println("Valor final: " + frete.getValorFinal());
        frete.pagar();
        frete.iniciarTransporte();
        frete.entregar();
    }
}
