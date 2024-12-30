import java.util.Arrays;
import java.util.Random;

public class DesempenhoOrdenacao {

    private static int trocas; // Variável para contar o número de trocas

    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 5000, 10000, 20000};
        String[] tiposDados = {"Aleatório", "Ordenado", "Reverso"};

        for (int tamanho : tamanhos) {
            for (String tipo : tiposDados) {
                int[] vetor = gerarVetor(tamanho, tipo);

                System.out.println("\nTamanho: " + tamanho + ", Tipo de Dados: " + tipo);

                // Teste de cada algoritmo
                testarSelectionSort(vetor.clone());
                testarInsertionSort(vetor.clone());
                testarBubbleSort(vetor.clone());
                testarMergeSort(vetor.clone());
                testarQuickSort(vetor.clone());
                testarArraysSort(vetor.clone());
            }
        }
    }

    // Métodos para testar cada algoritmo
    private static void testarSelectionSort(int[] vetor) {
        trocas = 0;
        long inicio = System.nanoTime();
        selectionSort(vetor);
        long fim = System.nanoTime();
        System.out.printf("Selection Sort: %.6f segundos, Trocas: %d%n", (fim - inicio) / Math.pow(10, 9), trocas);
    }

    private static void testarInsertionSort(int[] vetor) {
        trocas = 0;
        long inicio = System.nanoTime();
        insertionSort(vetor);
        long fim = System.nanoTime();
        System.out.printf("Insertion Sort: %.6f segundos, Trocas: %d%n", (fim - inicio) / Math.pow(10, 9), trocas);
    }

    private static void testarBubbleSort(int[] vetor) {
        trocas = 0;
        long inicio = System.nanoTime();
        bubbleSort(vetor);
        long fim = System.nanoTime();
        System.out.printf("Bubble Sort: %.6f segundos, Trocas: %d%n", (fim - inicio) / Math.pow(10, 9), trocas);
    }

    private static void testarMergeSort(int[] vetor) {
        trocas = 0;
        long inicio = System.nanoTime();
        mergeSort(vetor);
        long fim = System.nanoTime();
        System.out.printf("Merge Sort: %.6f segundos, Trocas: %d%n", (fim - inicio) / Math.pow(10, 9), trocas);
    }

    private static void testarQuickSort(int[] vetor) {
        trocas = 0;
        long inicio = System.nanoTime();
        quickSort(vetor);
        long fim = System.nanoTime();
        System.out.printf("Quick Sort: %.6f segundos, Trocas: %d%n", (fim - inicio) / Math.pow(10, 9), trocas);
    }

    private static void testarArraysSort(int[] vetor) {
        long inicio = System.nanoTime();
        Arrays.sort(vetor);
        long fim = System.nanoTime();
        System.out.printf("Arrays.sort: %.6f segundos (não rastreia trocas)%n", (fim - inicio) / Math.pow(10, 9));
    }

    // Métodos para gerar vetores
    private static int[] gerarVetor(int tamanho, String tipo) {
        int[] vetor = new Random().ints(tamanho, 0, 10000).toArray();

        if ("Ordenado".equals(tipo)) {
            Arrays.sort(vetor);
        } else if ("Reverso".equals(tipo)) {
            Arrays.sort(vetor);
            reverterVetor(vetor);
        }
        return vetor;
    }

    private static void reverterVetor(int[] vetor) {
        for (int i = 0, j = vetor.length - 1; i < j; i++, j--) {
            trocar(vetor, i, j);
        }
    }

    // Algoritmos de ordenação
    public static void selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMinimo]) indiceMinimo = j;
            }
            trocar(vetor, i, indiceMinimo);
        }
    }

    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                trocas++;
                j--;
            }
            vetor[j + 1] = chave;
        }
    }

    public static void bubbleSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    trocar(vetor, j, j + 1);
                }
            }
        }
    }

    public static void mergeSort(int[] vetor) {
        if (vetor.length < 2) return;
        int meio = vetor.length / 2;
        int[] esquerda = Arrays.copyOfRange(vetor, 0, meio);
        int[] direita = Arrays.copyOfRange(vetor, meio, vetor.length);
        mergeSort(esquerda);
        mergeSort(direita);
        merge(vetor, esquerda, direita);
    }

    private static void merge(int[] vetor, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;
        while (i < esquerda.length && j < direita.length) {
            vetor[k++] = (esquerda[i] <= direita[j]) ? esquerda[i++] : direita[j++];
            trocas++; // Contabiliza como troca
        }
        while (i < esquerda.length) {
            vetor[k++] = esquerda[i++];
        }
        while (j < direita.length) {
            vetor[k++] = direita[j++];
        }
    }

    public static void quickSort(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, pivo - 1);
            quickSort(vetor, pivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] < pivo) {
                trocar(vetor, ++i, j);
            }
        }
        trocar(vetor, i + 1, fim);
        return i + 1;
    }

    // Método utilitário para trocar elementos
    private static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
        trocas++; // Incrementa a contagem de trocas
    }
}
