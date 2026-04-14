package org.example;

public abstract class Animal {
    protected String nome;
    protected String som;

    public Animal(String nome, String som){
        this.nome = nome;
        this.som = som;
    }

    public abstract void fazerBarulho();

}
