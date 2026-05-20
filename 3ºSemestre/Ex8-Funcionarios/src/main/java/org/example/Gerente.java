package org.example;

public class Gerente extends Funcionario{

    public Gerente(double valor){
        super(valor);
    }

    @Override
    public void calcularBonus(){
        System.out.println("__________________________");
        System.out.println("Gerente salário:R$" + valor);
        System.out.println("__________________________");
    }
}
