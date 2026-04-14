package org.example;

public class Gato extends Animal{

    public Gato(String nome, String som) {
        super(nome, som);
    }

    @Override
    public void fazerBarulho(){
        System.out.println("O gato " + nome + " faz " + som);
    }
}
