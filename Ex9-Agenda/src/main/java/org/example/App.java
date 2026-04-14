package org.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Contato> contatos = new ArrayList<>();

        contatos.add(new ContatoPessoal("Fábio","012 985452655","01-03-2000"));
        contatos.add(new ContatoProfissional("Lara","012 56523475","Embraer"));


        for(Contato contato : contatos){
            contato.exibirDetalhes();
        }
    }
}