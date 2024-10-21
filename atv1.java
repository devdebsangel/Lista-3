
import java.util.Arrays;
import java.util.Random;

public class atv1 {
    public static void main(String[] args) {
        Random rnd = new Random(); // Inicia o gerador de números aleatórios
        int[] numeros = new int[10]; // Vetor para armazenar os 10 números

        // Preenche o vetor com números aleatórios entre 0 e 9
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rnd.nextInt(10); // Gera número aleatório de 0 a 9
        }

        // Exibe a lista de números obtidos
        System.out.println("Lista original de números: " + Arrays.toString(numeros));

        // Ordena o vetor em ordem crescente e exibe
        Arrays.sort(numeros);
        System.out.println("Lista em ordem crescente: " + Arrays.toString(numeros));

        // Ordena o vetor em ordem decrescente e exibe
        int[] numerosDecrescente = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numerosDecrescente[i] = numeros[numeros.length - 1 - i]; // Inverte a ordem
        }
        System.out.println("Lista em ordem decrescente: " + Arrays.toString(numerosDecrescente));
    }
}

