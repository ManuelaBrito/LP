package org.example;

public class Programador extends Funcionario {
    private String linguagem;

    public Programador (String nome,double salario,String linguagem) {
        super(nome, salario);
        this.linguagem = linguagem;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: R$ " + salario);
        System.out.println("Linguagem: " + linguagem);
    }
}
