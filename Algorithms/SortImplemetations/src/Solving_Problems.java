import java.util.Arrays;
import java.util.Random;

public class Solving_Problems {
    public static void main(String[] args) {
        //Cada exercício/desafio foi implementado separadamente para facilitar a correção

        desafio1();
        desafio2();
        desafio3();
        desafio4();
        desafio5();
        desafio6();
        desafio7();
        desafio8();
        desafio9();
        desafio10();
    }

    // Desafio 1: Implemente os três algoritmos de ordenação e uma função para imprimir

    public static void desafio1() {
        System.out.println("Implementando e Imprimindo os Três Algoritmos de Ordenação");
        int[] vetor = {10, 100, 50, 2, 1, 7, 100};
        System.out.println("Vetor Original: " + Arrays.toString(vetor));
        imprimir(vetor);
    }
    public static void imprimir(int[] input) {
        System.out.print("Resultado Selection Sort: ");
        selectionSort(input.clone());
        System.out.print("Resultado Insertion Sort: ");
        insertionSort(input.clone());
        System.out.print("Resultado Bubble Sort:    ");
        bubbleSort(input.clone());
    }

    // Desafio 2: Comparar o número de comparações e trocas dos três algoritmos

    public static void desafio2() {
        System.out.println("\n Comparando Comparações e Trocas dos três algoritmos em 3 vetores diversos");
        int[] ordenado = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] inverso = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] aleatorio = {5, 1, 9, 3, 7, 2, 8, 10, 4, 6};

        System.out.println("\n Vetor ordenado");
        compararStats(ordenado);

        System.out.println("\n Vetor ordenado inversamente");
        compararStats(inverso);

        System.out.println("\n Vetor com números aleatórios");
        compararStats(aleatorio);
    }

    public static void compararStats(int[] v) {
        long[] statsSelection = selectionSortWithStats(v.clone());
        long[] statsInsertion = insertionSortWithStats(v.clone());
        long[] statsBubble = bubbleSortWithStats(v.clone());

        System.out.printf("%-18s | Comparações: %-7d | Trocas: %d\n", "Selection Sort", statsSelection[0], statsSelection[1]);
        System.out.printf("%-18s | Comparações: %-7d | Trocas: %d\n", "Insertion Sort", statsInsertion[0], statsInsertion[1]);
        System.out.printf("%-18s | Comparações: %-7d | Trocas: %d\n", "Bubble Sort", statsBubble[0], statsBubble[1]);
    }

    // Desafio 3: Comparar o tempo de execução para vetores grandes (100, 1.000 e 10.000 elementos aleatórios)

    public static void desafio3() {
        System.out.println("\n Comparando Tempo de Execução");
        int[] tamanhos = {100, 1000, 10000};
        Random random = new Random();

        for (int tamanho : tamanhos) {
            System.out.println("\n--- Testando com " + tamanho + " elementos aleatórios ---");
            int[] vetorAleatorio = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                vetorAleatorio[i] = random.nextInt(tamanho * 10);
            }

            long startTime, endTime;

            // Selection Sort
            int[] copiaSelection = vetorAleatorio.clone();
            startTime = System.nanoTime();
            selectionSort(copiaSelection);
            endTime = System.nanoTime();
            System.out.printf("Tempo Selection Sort: %d ms\n", (endTime - startTime) / 1_000_000);

            // Insertion Sort
            int[] copiaInsertion = vetorAleatorio.clone();
            startTime = System.nanoTime();
            insertionSort(copiaInsertion);
            endTime = System.nanoTime();
            System.out.printf("Tempo Insertion Sort: %d ms\n", (endTime - startTime) / 1_000_000);

            // Bubble Sort
            int[] copiaBubble = vetorAleatorio.clone();
            startTime = System.nanoTime();
            bubbleSort(copiaBubble);
            endTime = System.nanoTime();
            System.out.printf("Tempo Bubble Sort:    %d ms\n", (endTime - startTime) / 1_000_000);
        }
    }

    // Desafio 4: Comparar busca binária com busca sequencial

    public static void desafio4() {
        System.out.println("\n Comparando Busca Sequencial e Binária");
        int[] vetor = new int[1000];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i * 2;
        }
        int valorMeio = vetor[vetor.length / 2];
        compararBuscas(vetor, valorMeio);
    }

    public static void compararBuscas(int[] vetor, int valor) {
        long[] resSeq = sequentialSearch(vetor, valor);
        long[] resBin = binarySearch(vetor, valor);
        System.out.printf("Busca Sequencial: Posição %d, Comparações: %d\n", resSeq[0], resSeq[1]);
        System.out.printf("Busca Binária:    Posição %d, Comparações: %d\n", resBin[0], resBin[1]);
    }

    //Desafio 5: Criar uma função que determine qual Melhor Ordenação para um vetor de inteiros

    public static void desafio5() {
        System.out.println("\n Determinando a Melhor Ordenação para um Vetor de inteiros");
        int[] aleatorio = {5, 1, 9, 3, 7, 2, 8, 10, 4, 6};
        qualMelhorOrdenacao(aleatorio);
    }

    public static void qualMelhorOrdenacao(int[] v) {
        System.out.println("Analisando o vetor: " + Arrays.toString(v));

        long startTime = System.nanoTime();
        long[] statsSelection = selectionSortWithStats(v.clone());
        long timeSelection = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        long[] statsInsertion = insertionSortWithStats(v.clone());
        long timeInsertion = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        long[] statsBubble = bubbleSortWithStats(v.clone());
        long timeBubble = System.nanoTime() - startTime;

        System.out.printf("Selection: %d ns, %d comp, %d trocas\n", timeSelection, statsSelection[0], statsSelection[1]);
        System.out.printf("Insertion: %d ns, %d comp, %d trocas\n", timeInsertion, statsInsertion[0], statsInsertion[1]);
        System.out.printf("Bubble:    %d ns, %d comp, %d trocas\n", timeBubble, statsBubble[0], statsBubble[1]);

        //Calcular qual o retorno é menor
        long melhorTempo = Math.min(timeSelection, Math.min(timeInsertion, timeBubble));

        System.out.print("O algoritmo mais rápido para o caso testado foi: ");
        if (melhorTempo == timeInsertion) System.out.println("Insertion Sort foi o mais rápido.");
        else if (melhorTempo == timeBubble) System.out.println("Bubble Sort foi o mais rápido.");
        else System.out.println("Selection Sort foi o mais rápido.");
    }

    // Desafio 6: Descobrir algoritmo usar para uma loja com até 100 produtos

    public static void desafio6() {
        System.out.println("\n Melhor algoritmo para ordenar produtos (Até 100) de uma Loja pequena");
        System.out.println("Justificativa: Para o caso apresentado, Insertion Sort é uma excelente escolha por ser simples, eficiente para poucos dados e performar muito bem se a lista já estiver quase ordenada (ex: ao adicionar um novo produto).");
    }

    // Desafio 7: Qual algoritmo é menos recomendado para inserções constantes (Justificar e Implementar)

    public static void desafio7() {
        System.out.println("\n Pior Algoritmo para Inserções Constantes ");
        System.out.println("Justificativa: Selection Sort é o menos recomendado. Ele não se beneficia de dados quase ordenados. A cada re-ordenação, ele percorrerá a lista inteira para encontrar o mínimo, realizando sempre O(n²) comparações, mesmo que apenas um item esteja fora do lugar.");

        int[] vetorQuaseOrdenado = {10, 20, 30, 40, 50, 15};
        System.out.println("\n Testando o algoritmo Selection Sort:");
        long[] statsSelection = selectionSortWithStats(vetorQuaseOrdenado.clone());
        System.out.printf("Comparações: %d, Trocas: %d\n", statsSelection[0], statsSelection[1]);

    }

    // Desafio 8: Qual algoritmo é mais eficiente para notas quase ordenadas? (Justificar e Demonstrar)

    public static void desafio8() {
        System.out.println("\n Melhor Algoritmo para Dados Quase Ordenados");
        System.out.println("Justificativa: Insertion Sort. Ele possui complexidade de melhor caso O(n), podendo ser até O(1). Quando o vetor está quase ordenado, cada novo elemento é comparado poucas vezes antes de encontrar seu lugar, resultando em poucas operações.");

        double[] notasQuaseOrdenadas = {5.5, 6.0, 7.5, 6.8, 8.0, 9.5, 10.0};

        System.out.println("Resultado com Insertion Sort: ");
        insertionSortDoubles(notasQuaseOrdenadas.clone());
    }

    // Desafio 9: Ordene 20 nomes com insertion sort e mostre os passos.

    public static void desafio9() {
        System.out.println("\n Insertion Sort com Nomes (Passo a Passo)");
        String[] alunos = {
                "Carlos", "Ana", "Zoe", "Bruno", "Debora", "Fabio", "Yasmin", "Gabriel", "Heitor",
                "Isabela", "Jorge", "Larissa", "Miguel", "Natalia", "Otavio", "Patricia", "Ricardo",
                "Sofia", "Thiago", "Valeria"
        };
        insertionSortStringsComPassos(alunos);
    }

    // Desafio 10: Fazer uma tabela comparativa dos algoritmos.

    public static void desafio10() {
        System.out.println("+------------------+------------------+------------------+------------------+");
        System.out.println("| CARACTERÍSTICAS   | SELECTION SORT   | INSERTION SORT   | BUBBLE SORT      |");
        System.out.println("+------------------+------------------+------------------+------------------+");
        System.out.println("| Complexidade     |                  |                  |                  |");
        System.out.println("| - Melhor Caso    | O(n²)            | O(n)             | O(n)             |");
        System.out.println("| - Caso Médio     | O(n²)            | O(n²)            | O(n²)            |");
        System.out.println("| - Pior Caso      | O(n²)            | O(n²)            | O(n²)            |");
        System.out.println("+------------------+------------------+------------------+------------------+");
        System.out.println("| Estabilidade     | Não (instável)   | Sim (estável)    | Sim (estável)    |");
        System.out.println("+------------------+------------------+------------------+------------------+");
        System.out.println("| Uso Recomendado  | Poucos dados,    | Poucos dados,    | Fins didáticos.  |");
        System.out.println("|                  | onde trocas são  | dados quase      | Raramente usado  |");
        System.out.println("|                  | custosas.        | ordenados.       | na prática.     |");
        System.out.println("+------------------+------------------+------------------+------------------+");

    }

    // Métodos de ordanação usados nas questões/desafios

    public static void selectionSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
        }
        System.out.println(Arrays.toString(vetor));
    }

    public static void insertionSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
        System.out.println(Arrays.toString(v));
    }

    public static void bubbleSort(int[] v) {
        boolean houveTroca;
        for (int i = 0; i < v.length - 1; i++) {
            houveTroca = false;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    houveTroca = true;
                }
            }
            if (!houveTroca) {
                break;
            }
        }
        System.out.println(Arrays.toString(v));
    }

    // Metódos de ordenação, mas com funções a mais (Mostrar estatisticas)

    public static long[] selectionSortWithStats(int[] vetor) {
        long comparacoes = 0, trocas = 0;
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                trocas++;
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
        }
        return new long[]{comparacoes, trocas};
    }

    public static long[] insertionSortWithStats(int[] v) {
        long comparacoes = 0, trocas = 0;
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && (comparacoes++ >= 0) && v[j] > chave) {
                v[j + 1] = v[j];
                trocas++; // Cada deslocamento é uma operação de escrita
                j--;
            }
            v[j + 1] = chave;
            if (i != j+1) trocas++; // A inserção final da chave
        }
        return new long[]{comparacoes, trocas};
    }

    public static long[] bubbleSortWithStats(int[] v) {
        long comparacoes = 0, trocas = 0;
        boolean houveTroca;
        for (int i = 0; i < v.length - 1; i++) {
            houveTroca = false;
            for (int j = 0; j < v.length - 1 - i; j++) {
                comparacoes++;
                if (v[j] > v[j + 1]) {
                    trocas++;
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    houveTroca = true;
                }
            }
            if (!houveTroca) break;
        }
        return new long[]{comparacoes, trocas};
    }

    //Binary Search e Sequential/Linear Search

    public static long[] sequentialSearch(int[] vetor, int valor) {
        long comparacoes = 0;
        for (int i = 0; i < vetor.length; i++) {
            comparacoes++;
            if (vetor[i] == valor) {
                return new long[]{i, comparacoes}; // [índice, comparações]
            }
        }
        return new long[]{-1, comparacoes}; // Não encontrado
    }

    public static long[] binarySearch(int[] vetor, int valor) {
        long comparacoes = 0;
        int inicio = 0, fim = vetor.length - 1;
        while (inicio <= fim) {
            comparacoes++;
            int meio = inicio + (fim - inicio) / 2;
            if (vetor[meio] == valor) {
                return new long[]{meio, comparacoes};
            }
            if (vetor[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return new long[]{-1, comparacoes};
    }

    // Classe produto + Variações de Insection Sort

    static class Produto {
        String nome;
        double preco;
        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }
        @Override
        public String toString() {
            return String.format("%-10s | R$ %.2f", nome, preco);
        }
    }

    public static void insertionSortDoubles(double[] v) {
        for (int i = 1; i < v.length; i++) {
            double chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
        System.out.println("Resultado: " + Arrays.toString(v));
    }

    public static void insertionSortStringsComPassos(String[] v) {
        System.out.println("Vetor Original: " + Arrays.toString(v));
        for (int i = 1; i < v.length; i++) {
            String chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].compareTo(chave) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
            System.out.println("Após inserir '" + chave + "': " + Arrays.toString(v));
        }
    }
}