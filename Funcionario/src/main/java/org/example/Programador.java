package org.example;

public class Programador extends Funcionario{
    private String linguagem;
    private final double bonus = 0.10;

    public Programador(String nome, double salario, String linguagem){
        super(nome, salario);
        this.linguagem = linguagem;
    }

    @Override
    public double getSalario(){
        double bonus = salario * 0.10;
        return salario + bonus;
    }

    @Override
    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Linguagem: " + linguagem);
        System.out.println("Salário: " + getSalario());
    }
}
