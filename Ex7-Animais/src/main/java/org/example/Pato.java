package org.example;

public class Pato extends Animal {

    public Pato(String nome,String som){
        super(nome, som);
    }

    @Override
    public void fazerBarulho() {
        System.out.println("O pato " + nome + " faz " + som);
    }
}
