package org.example;

public class Desenvolvedor extends Funcionario {
    private double adicional = 0.10;

    public Desenvolvedor(double valor, double adicional){
        super(valor);
        this.adicional=adicional;
    }

    @Override
    public void calcularBonus(){
        double valorAdicional = valor * (1 + adicional);
        System.out.println("__________________________");
        System.out.println("Desenvolvedor salário:R$" + valorAdicional);
        System.out.println("__________________________");
    }
}
