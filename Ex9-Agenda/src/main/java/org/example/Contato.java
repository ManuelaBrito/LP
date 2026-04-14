package org.example;

public abstract class Contato {
    protected String nome;
    protected String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public abstract void exibirDetalhes();

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
