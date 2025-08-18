import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bubble_Sort {
    public static void main(String[] args) {
        //Inputs para teste
        int[] intVector = {6,3,8,4,2};
        int[] sortedIntVector = {1,2,3,4,5};
        double[] Doubles = { 1.1, 100.1, 8.8, 5.5, 3.3, 2.2 };
        int[] tenIntegers = { 1, 100, 10, 7, 6, 8, 5, 4,3,2 };
        String[] names = {"Caio", "Ariel", "Boston", "Pacers", "Espanha", "Portugal"};

        //Testes

        System.out.println("--- Exercício 1 (Aplicando Bubble Sort) ---");
        int[] sortedIntegers = bubbleSort(tenIntegers.clone());
        System.out.println("Vetor ordenado: " + Arrays.toString(sortedIntegers));

        System.out.println("\n--- Exercício 2 (Passo a Passo do BubbleSort) ---");
        bubbleSortSteps(intVector);

        System.out.println("\n--- Exercício 3 (BubbleSort Decrescente) ---");
        int[]reversesortedintegers = bubbleReverseSort(tenIntegers.clone());
        System.out.println("Vetor ordenado de forma Decrescente: " + Arrays.toString(reversesortedintegers));


        System.out.println("\n--- Exercício 4 (BubleSort com Strings) ---");
        String[] sortedStrings = stringBubbleSort(names.clone());
        System.out.println("Vetor ordenado: " + Arrays.toString(sortedStrings));


        System.out.println("\n--- Exercício 5 + 6 (BubleSort Otimizado para interromper se não houver trocas/Teste do algoritmo otimizado com um vetor já ordenado) ---");
        optimizedBubbleSort(intVector);
        optimizedBubbleSort(sortedIntVector);

        System.out.println("\n--- Exercício 7 (Exibir o número de trocas de um BubbleSort) ---");
        bubbleSortSwitches(intVector);

        System.out.println("\n--- Exercício 8 (BubbleSort com Números Decimais) ---");
        double[] sortedDecimals = doubleBubbleSort(Doubles.clone());
        System.out.println("Vetor ordenado: " + Arrays.toString(sortedDecimals));

        System.out.println("\n--- Exercício 9 (Comparando o desempenho de BubbleSort com InserctionSort em 1000 elementos) ---");
        exercicio9();

        System.out.println("\n--- Exercício 10 (Por que BubbleSort não é utilizado em aplicações de grande escala?) ---");
        System.out.println("O Bubble Sort não é utilizado em aplicações de grande escala por sua baixa performance. Sua complexidade de tempo no caso médio e no pior caso é O(n²)");
    }


    //Implementações
        public static int[] bubbleSort (int[] v) {
            for (int i = 0; i < v.length -1; i++) {
                for (int j = 0; j < v.length - 1 - i; j++) {
                    if (v[j] > v[j + 1]) {
                        int temp = v[j];
                        v[j] = v[j + 1];
                        v[j + 1] = temp;
                    }
                }
            }
            return v;
        }

    public static String[] stringBubbleSort (String[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j].compareTo(v[j+1]) > 0) {
                    String temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
        return v;
    }
    public static double[] doubleBubbleSort (double[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j+1]) {
                    double temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
        return v;
    }

        //Outras versões com diferentes funções

        public static void bubbleSortSteps (int[] v) {
        for (int i = 0; i < v.length -1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
            System.out.println("Após a " + (i + 1) + "ª passagem: " + Arrays.toString(v));
        }
    }


    public static void bubbleSortSwitches(int[] v) {
        int[] vetorParaContagem = v.clone();
        int n = vetorParaContagem.length;
        int contadorDeTrocas = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetorParaContagem[j] > vetorParaContagem[j + 1]) {
                    contadorDeTrocas++;
                    int temp = vetorParaContagem[j];
                    vetorParaContagem[j] = vetorParaContagem[j + 1];
                    vetorParaContagem[j + 1] = temp;
                }
            }
        }
        System.out.println("Foram feitas " + contadorDeTrocas + " trocas para ordenar o vetor " + Arrays.toString(v));
    }


    public static int[] bubbleReverseSort (int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] < v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
        return v;
    }


    public static void optimizedBubbleSort(int[] v) {
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
                System.out.println("O algoritmo parou na " + (i + 1) + "ª passagem, pois já estava ordenado");
                break;
            }
        }
    }


    //Exercicio 9
    public static void exercicio9() {


        Random random = new Random();
            int[] vetorOriginal = new int[1000];
            //Preenchendo o vetor de teste com 1000 números aleatórios
            for (int i = 0; i < 1000; i++) {
                vetorOriginal[i] = random.nextInt(1000);
            }

            //Teste Bubble
            int[] copiaParaBubble = vetorOriginal.clone();
            long startTimeBubble = System.nanoTime();
            optimizedBubbleSort(copiaParaBubble);
            long endTimeBubble = System.nanoTime();
            long durationBubble = (endTimeBubble - startTimeBubble) / 1_000_000;
            System.out.println("Bubble Sort:    " + durationBubble + " ms");

            //Teste Inserction

            int[] copiaParaInsertion = vetorOriginal.clone();
            long startTimeInsertion = System.nanoTime();
            Inserction_Sort inserctionSortObj = new Inserction_Sort();
            inserctionSortObj.inserctionSort(copiaParaInsertion);
            long endTimeInsertion = System.nanoTime();
            long durationInsertion = (endTimeInsertion - startTimeInsertion) / 1_000_000;
            System.out.println("Insertion Sort: " + durationInsertion + " ms");
        }
    }

