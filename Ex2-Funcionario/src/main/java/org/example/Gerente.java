package org.example;

public class Gerente extends Funcionario {
    private String departamento;

    public Gerente (String nome, double salario, String departamento) {
        super(nome,salario);
        this.departamento = departamento;
    }

    @Override
    public void exibirInformacoes () {
        System.out.println("NOME DO FUNCIONARIO: " + nome );
        System.out.println("SEU CARGO É GERENCIA");
        System.out.println("SEU SALÁRIO É R$ " + salario);
        System.out.println("DEPARTAMENTO: " + departamento);
    }
}
