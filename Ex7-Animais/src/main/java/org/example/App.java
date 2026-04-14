
package org.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Animal> animais = new ArrayList<>();

        animais.add(new Cachorro("Rex","AUAU"));
        animais.add(new Gato("Raul","MIAU"));
        animais.add(new Pato("Luiz","QUACK"));



        for (Animal animal : animais) {
            animal.fazerBarulho();
        }
    }
}
