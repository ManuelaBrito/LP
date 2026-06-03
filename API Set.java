import java.util.HashSet;
import java.util.Set;

public class ExemploSet {
    public static void main(String[] args) {
        Set<String> frutas = new HashSet<>();
        
        // add
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Maçã"); // duplicata, será ignorada
        System.out.println("Set: " + frutas); 
        // Saída possível: [Banana, Maçã, Laranja] (ordem arbitrária)
        
        // size
        System.out.println("Tamanho: " + frutas.size()); // 3
        
        // contains
        System.out.println("Tem Maçã? " + frutas.contains("Maçã")); // true
        System.out.println("Tem Uva? " + frutas.contains("Uva"));   // false
        
        // remove
        frutas.remove("Banana");
        System.out.println("Após remover Banana: " + frutas); // [Maçã, Laranja]
        
        // isEmpty
        System.out.println("Está vazio? " + frutas.isEmpty()); // false
        
        // Percorrendo com for-each
        System.out.print("Elementos: ");
        for (String f : frutas) {
            System.out.print(f + " ");
        }
        // Saída: Maçã Laranja (ordem pode variar)
    }
}