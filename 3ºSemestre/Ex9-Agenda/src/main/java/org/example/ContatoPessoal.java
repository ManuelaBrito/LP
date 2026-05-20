package org.example;

public class ContatoPessoal extends Contato{
    private String aniversario;

    public ContatoPessoal(String nome, String telefone, String aniversario){
        super(nome, telefone);
        this.aniversario = aniversario;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("CONTATO PESSOAL");
        System.out.println("NOME: " + nome);
        System.out.println("NÚMERO: " + telefone);
        System.out.println("ANIVERSÁRIO: " + aniversario);
        System.out.println("____________________________");
    }
}
