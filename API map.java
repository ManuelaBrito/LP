import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        // HashMap - sem ordenação
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Zebra", 3);
        hashMap.put("Macaco", 5);
        hashMap.put("Abelha", 2);
        System.out.println("HashMap: " + hashMap);
        // Exemplo: {Abelha=2, Macaco=5, Zebra=3} (ordem depende do hash)
        
        // TreeMap - ordenado pelas chaves (ordem natural)
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 3);
        treeMap.put("Macaco", 5);
        treeMap.put("Abelha", 2);
        System.out.println("TreeMap: " + treeMap);
        // Saída: {Abelha=2, Macaco=5, Zebra=3} (alfabética)
        
        // Métodos comuns
        treeMap.put("Macaco", 8); // substitui
        System.out.println("Novo valor do Macaco: " + treeMap.get("Macaco")); // 8
        
        // keySet e iteração
        System.out.print("Chaves ordenadas: ");
        for (String chave : treeMap.keySet()) {
            System.out.print(chave + " ");
        }
        // Saída: Abelha Macaco Zebra
    }
}