//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual seu nome?");
        String nome = sc.nextLine();
        System.out.println();

        System.out.println("Olá " + nome + ", Qual foi sua nota na Prova?");
        double p1;
        do {
            if (sc.hasNextDouble()) {
                p1 = sc.nextDouble();
            } else {
                System.out.println("NOTA INVÁLIDA!");
                sc.next();
                p1 = -1;
            }
        } while (p1 < 0 || p1 > 10);

        System.out.println("Qual foi sua nota na entrega 1?");
        double entrega1;
        do {
            if (sc.hasNextDouble()) {
                entrega1 = sc.nextDouble();
            } else {
                System.out.println("NOTA INVÁLIDA!");
                sc.next();
                entrega1 = -1;
            }
        } while (entrega1 < 0 || entrega1 > 10);


        System.out.println("Qual foi sua nota na entrega 2?");
        double entrega2;
        do {
            if (sc.hasNextDouble()) {
                entrega2 = sc.nextDouble();
            } else {
                System.out.println("NOTA INVÁLIDA!");
                sc.next();
                entrega2 = -1;
            }
        } while (entrega2 < 0 || entrega2 > 10);

        System.out.println("Qual foi sua nota respectiva a atividades complementares?");
        double at;
        do {
            if (sc.hasNextDouble()) {
                at = sc.nextDouble();
            } else {
                System.out.println("NOTA INVÁLIDA!");
                sc.next();
                at = -1;
            }
        } while (at < 0 || at > 10);

        System.out.println("Nota da sub:");
        double sub;
        do {
            if (sc.hasNextDouble()) {
                sub = sc.nextDouble();
            } else {
                System.out.println("NOTA INVÁLIDA!");
                sc.next();
                sub = -1;
            }
        } while (sub < 0 || sub > 10);

        System.out.println("Qual foi sua nota de API?");
        double API;
        do {
            if (sc.hasNextDouble()) {
                API = sc.nextDouble();
            } else {
                System.out.println("NOTA INVÁLIDA!");
                sc.next();
                API = -1;
            }
        } while (API < 0 || API > 10);
        sc.nextLine();

        double media1 = ((p1*0.5) + (entrega1*0.2) + (entrega2*0.3) + (at*0.1) + (sub*0.15));
        double media2 = (media1*0.5);
        double media3 = (media2-5.9);
        double media4 = API;
        double media5 = (media4/4);
        double mediafinal = media2+ media5;
        System.out.printf("Média Final: %.2f%n ", mediafinal);

    }
    }
