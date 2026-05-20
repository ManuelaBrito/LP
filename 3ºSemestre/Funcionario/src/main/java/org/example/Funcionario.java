package org.example;

public abstract class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }



    public void exibirInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Salário base R$: " + salario);
    }

    public double getSalario() {
        return salario;
    }
}
