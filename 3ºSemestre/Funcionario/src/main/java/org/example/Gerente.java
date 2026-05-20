package org.example;

public class Gerente extends Funcionario{
    private String departamento;
    private final double bonus = 500.00;

    public Gerente(String nome, double salario, String departamento){
        super(nome, salario);
        this.departamento = departamento;
    }

    @Override
    public double getSalario() {
        return salario + bonus;
    }


    @Override
    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Departamento: " + departamento);
        System.out.println("Salário: R$" + getSalario());
    }
}
