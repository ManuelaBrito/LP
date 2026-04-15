package org.example;

public class App {
    public static void main(String[] args) {

        Funcionario[] funcionarios = new Funcionario[2];

        funcionarios[0] = new Gerente("Carla Silva", 8000.00, "TI");
        funcionarios[1] = new Programador("Ana Costa", 5000.00, "Java");


        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("--- Funcionário " + (i+1) + " ---");
            funcionarios[i].exibirInfo();
            System.out.println();
        }

    }
}