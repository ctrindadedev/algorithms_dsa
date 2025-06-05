import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Selection_Sort {
    public static void main(String[] args) {

        //Inputs para os exercicíos

        int[] tenIntegers = { 1, 100, 10, 7, 6, 8, 5, 4,3 , 2 };
        int[] eightIntegers = { 1, 100, 10, 7, 6, 8, 576, 400 };
        int[] nineIntegers = { 1, 100, 10, 7, 6, 8, 576};
        double[] tenDoubles = { 1.1, 100.1, 10.1, 7.7, 8.8, 5.5, 4.4, 3.3, 2.2 };
        int[] eightUserInputs = new int[8];
        String[] fiveLetters = {"u", "o", "i", "e", "a"};

        //Testes

        System.out.println("--- Exercício 1 e 7 (Selection Sort + Busca Binária) ---");
        //Exercicío 1 + 7
        int[] sortedIntegers = integersOnlySelectionSort(tenIntegers);
        findInput(sortedIntegers, 100);
        System.out.println("Vetor ordenado: " + Arrays.toString(sortedIntegers));

        System.out.println("\n--- Exercício 2 (Passo a Passo do SelectionSort) ---");

        //Exercicío 2
        selectionSortSteps(eightIntegers);

        //Exercicío 3
        System.out.println("\n--- Exercício 3 (Leitura de 8 números e ordenação) ---");
        exercicio3();

       //Exercicío 4
        System.out.println("\n--- Exercício 4 (Ordem Decrescente SelectionSort) ---");
        System.out.println("Vetor ordenado decrescente: " + Arrays.toString(reverseSelectionSort(nineIntegers)));

        //Exercicío 5
        System.out.println("\n--- Exercício 5 (Selection Sort com Strings) ---");
        selectionSortStrings(fiveLetters);


        //Exercicíos com entrada do User

        System.out.println("\n--- Exercício 6 (Leitura de 5 nomes para serem ordenados ---");
         exercicio6();

        System.out.println("\n--- Exercício 8 (Comparação de Selection Sort com Bubble Sort) ---");
        exercicio8();

        System.out.println("\n--- Exercício 9 (Selection Sort com Doubles) ---");

        System.out.println("Vetor de doubles ordenado: " + Arrays.toString(selectionSort(tenDoubles)));

        System.out.println("\n--- Exercício 10 (Leitura de notas de alunos e ordenação) ---");
        exercicio10();
    }

        //Implementações
        public static double[] selectionSort(double[] vetor) {
            int n = vetor.length;
            for (int i = 0; i < n - 1; i++) { // Loop externo
                int indiceMenor = i; // Assume o atual como menor
                for (int j = i + 1; j < n; j++) { // Encontra o menor no restante
                    if (vetor[j] < vetor[indiceMenor]) {
                        indiceMenor = j;
                    }
                }
                // Faz a troca APÓS encontrar o menor
                if (indiceMenor != i) {
                    double temp = vetor[i];
                    vetor[i] = vetor[indiceMenor];
                    vetor[indiceMenor] = temp;
                }
            }
            return vetor;
        };

    public static int[] integersOnlySelectionSort(int[] vetor) {
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
        return vetor;
    }
        public static int[] selectionSortSteps(int[] vetor){
                int n = vetor.length;
                for (int i = 0; i < n - 1; i++) {
                    int indiceMenor = i;
                    for (int j = i + 1; j < n; j++) {
                        if (vetor[j] < vetor[indiceMenor]) {
                            indiceMenor = j;
                        }
                    }
                    boolean trocou = false;
                    if (indiceMenor != i) {
                        int temp = vetor[i];
                        vetor[i] = vetor[indiceMenor];
                        vetor[indiceMenor] = temp;
                        trocou = true;
                    }
                    if (trocou) {
                        System.out.println("Após passo " + (i + 1) + " (troca efetuada, " + vetor[i] + " na posição " + i + "): " + Arrays.toString(vetor));
                    } else {
                        System.out.println("Após passo " + (i + 1) + " (sem trocas, " + vetor[i] + " já estava correto): " + Arrays.toString(vetor));
                    }
                }
                System.out.println("Vetor final ordenado: " + Arrays.toString(vetor));
                return vetor;
            };

        //public static int[] reverseSelectionSort(int[] vetor){
            //int temp = 0;
            //for (int i = 0; i < vetor.length; i++) {
                //for (int j = i + 1; j < vetor.length; j++) {
                  //  if (vetor[i] < vetor[j]) {
                     //   temp = vetor[j];
                       // vetor[j] = vetor[i];
                       // vetor[i] = temp;
                    //}
                //}
            //}
            //System.out.print(Arrays.toString(vetor));

            //return vetor;

        //}

        public  static  int findInput(int[] array, int target) {
            int ini = 0, fim = array.length - 1;
            while (ini <= fim) {
                int meio = (ini + fim) / 2;
                if (array[meio] == target) {
                    System.out.println("O input informado existe no vetor.");
                    return meio;
                } else if (array[meio] < target) ini = meio + 1;
                else fim = meio - 1;
            }
            return -1;
        }


    public static int[] reverseSelectionSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMaior = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] > vetor[indiceMaior]) {
                    indiceMaior = j;
                }
            }
            if (indiceMaior != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMaior];
                vetor[indiceMaior] = temp;
            }
        }
        return vetor;
    }


    public static String[] selectionSortStrings(String[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j].compareTo(vetor[indiceMenor]) < 0) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                String temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
        }
        return vetor;
    }

    public static double[] selectionSortDoubles(double[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                double temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
        }
        return vetor;
    }



    // Implementações para exercicíos com leitura

    public static void exercicio3() {
        Scanner scanner = new Scanner(System.in);
        int[] eightUserInputs = new int[8];

        System.out.println("Digite 8 números inteiros, um por vez:");
        for (int i = 0; i < eightUserInputs.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            eightUserInputs[i] = scanner.nextInt();
        }

        System.out.println("Vetor original: " + Arrays.toString(eightUserInputs));
        integersOnlySelectionSort(eightUserInputs);
        System.out.println("Vetor ordenado: " + Arrays.toString(eightUserInputs));
        // scanner.close(); // Considerar fechar o scanner se for o fim do programa.
    }


    public static void exercicio6() {
        Scanner scanner = new Scanner(System.in);
        String[] fiveNames = new String[5];

        System.out.println("Digite 5 nomes, um por vez:");
        for (int i = 0; i < fiveNames.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            fiveNames[i] = scanner.nextLine();
        }

        System.out.println("Nomes originais: " + Arrays.toString(fiveNames));
        selectionSortStrings(fiveNames);
        System.out.println("Nomes ordenados: " + Arrays.toString(fiveNames));
        // scanner.close();
    }

     // Bubble Sort para o Exercício 8

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }


     //Gera um vetor de inteiros aleatórios para o Exercício 8

    public static int[] gerarVetorAleatorio(int tamanho, int valorMaximo) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(valorMaximo);
        }
        return vetor;
    }


     //Exercício 8: Comparar performance do Selection Sort com Bubble Sort.


    public static void exercicio8() {
        int[] tamanhos = {100, 1000, 10000};

        System.out.println("Comparação de Performance (tempos em milissegundos):");
        for (int tamanho : tamanhos) {
            System.out.println("\n--- Para " + tamanho + " elementos ---");
            int[] vetorOriginal = gerarVetorAleatorio(tamanho, tamanho * 10);

            // Teste Selection Sort
            int[] copiaParaSelection = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            long startTimeSelection = System.nanoTime();
            integersOnlySelectionSort(copiaParaSelection);
            long endTimeSelection = System.nanoTime();
            long durationSelection = (endTimeSelection - startTimeSelection) / 1_000_000;
            System.out.println("Selection Sort: " + durationSelection + " ms");

            // Teste Bubble Sort
            int[] copiaParaBubble = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            long startTimeBubble = System.nanoTime();
            bubbleSort(copiaParaBubble);
            long endTimeBubble = System.nanoTime();
            long durationBubble = (endTimeBubble - startTimeBubble) / 1_000_000;
            System.out.println("Bubble Sort:    " + durationBubble + " ms");
        }
    }

    public static void exercicio10() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantas notas de alunos você deseja inserir? ");
        int numNotas = scanner.nextInt();
        double[] notas = new double[numNotas];

        System.out.println("Digite as " + numNotas + " notas:");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        System.out.println("Notas originais: " + Arrays.toString(notas));
        selectionSortDoubles(notas);
        System.out.println("Notas ordenadas: " + Arrays.toString(notas));
        // scanner.close();
    };
}



