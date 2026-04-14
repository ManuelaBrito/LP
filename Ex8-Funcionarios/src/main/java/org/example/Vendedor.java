package org.example;

public class Vendedor extends Funcionario {
    private double comissao = 0.30;

    public Vendedor(double valor, double comissao){
        super(valor);
        this.comissao=comissao;
    }

    @Override
    public void calcularBonus(){
        double ValorComissao = valor * (1 + comissao);
        System.out.println("__________________________");
        System.out.println("Vendendor salário:R$" + ValorComissao);
        System.out.println("__________________________");
    }
}
