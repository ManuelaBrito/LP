package org.example;

public class ContatoProfissional extends Contato{
    private String empresa;

    public ContatoProfissional(String nome, String telefone, String empresa){
        super(nome, telefone);
        this.empresa = empresa;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("CONTATO PROFISSIONAL");
        System.out.println("NOME: " + nome);
        System.out.println("TELEFONE: " + telefone);
        System.out.println("EMPRESA: " + empresa);
        System.out.println("____________________________");
    }
}
