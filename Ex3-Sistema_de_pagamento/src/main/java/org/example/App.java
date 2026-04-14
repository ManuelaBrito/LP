// Classe Main para demonstrar
package org.example;

public class App {
    public static void main(String[] args) {
        // Demonstração de polimorfismo
        ContaBancaria[] contas = new ContaBancaria[2];

        contas[0] = new ContaCorrente(1000.00);
        contas[1] = new ContaPoupanca(1000.00);

        System.out.println("=== DEMONSTRAÇÃO DE POLIMORFISMO ===\n");

        // Mesmo método sacar() se comporta diferente para cada conta
        for (ContaBancaria conta : contas) {
            conta.sacar(100.00);
            System.out.println();
        }

        // Testando método específico da poupança
        System.out.println("=== TESTE ESPECÍFICO ===");
        ContaPoupanca poupanca = (ContaPoupanca) contas[1];
        poupanca.renderJuros();
    }
}