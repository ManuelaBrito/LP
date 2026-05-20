package org.example;

public class Cachorro extends Animal {

    public Cachorro(String nome, String som){
        super(nome, som);
    }

    @Override
    public void fazerBarulho(){
        System.out.println("O cachorro " + nome + " faz " + som);
    }
}
