package org.example;


import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente(3000.00));
        funcionarios.add(new Vendedor(1500.00,0.30));
        funcionarios.add(new Desenvolvedor(3000.00,0.10));


        for ( Funcionario funcionario : funcionarios ){
            funcionario.calcularBonus();
        }
    }
}