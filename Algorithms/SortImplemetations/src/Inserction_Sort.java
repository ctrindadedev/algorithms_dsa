import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Inserction_Sort {
    public static void main(String[] args) {
        //Inputs
        double[] Doubles = {1.1, 100.1, 8.8, 5.5, 3.3, 2.2};
        int[] tenIntegers = {1, 100, 10, 7, 6, 8, 5, 4, 3, 2};
        int[] intVector = {7,4,5,2};
        String[] names = {"Caio", "Ariel", "Boston", "Pacers", "Espanha", "Portugal"};
        Inserction_Sort inserctionSortobj = new Inserction_Sort();
        //Testes

        System.out.println("--- Exercício 1 (Aplicando Inserction Sort num vetor de 10 inteiros desordenados) ---");
        int[] sortedIntegers = inserctionSortobj.inserctionSort(intVector.clone());
        System.out.println("Vetor ordenado: " + Arrays.toString(sortedIntegers));

        System.out.println("\n--- Exercício 2 (Passo a Passo do Inserction Sort) ---");
        inserctionSortSteps(intVector);


        System.out.println("\n--- Exercício 3 (Inserction Sort para 8 inputs do user) ---");
        exercicio3();

        System.out.println("\n--- Exercício 4 (Inserction Sort ordenando em ordem decrescente) ---");
        int[] reverseSortedIntegers = inserctionReverseSort(intVector.clone());
        System.out.println("Vetor ordenado decrescente: " + Arrays.toString(reverseSortedIntegers));


        System.out.println("\n--- Exercício 5/6 (Inserction Sort com Strings) ---");
        String[] sortedNames = inserctionSortStrings(names.clone());
        System.out.println("Vetor  de strings ordenado: " + Arrays.toString(sortedNames));


        System.out.println("\n--- Exercício 7 (Comparando o desempenho de Selection Sort om InserctionSort em 1000 elementos) ---");


        System.out.println("\n--- Exercício 8 (Inserction Sort com Números do tipo Double) ---");
        double[] sortedDoubles = inserctionSortDoubles(Doubles.clone());
        System.out.println("Vetor de doubles ordenado: " + Arrays.toString(sortedDoubles));


        System.out.println("\n--- Exercício 9 (Ler notas de 6 alunos e as ordenar em ordem crescente com InserctionSort) ---");
        exercicio9();

        System.out.println("\n--- Exercício 10 (Busca binária para localizar um valor inserido pelo usuário, dado um vetor ordenado) ---");
            BinarySearch binarySearch = new BinarySearch();
            binarySearch.findInput(sortedIntegers, 5);
    }

    //Implementação dos Metódos
    public int[] inserctionSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    return v;
    }

    public static String[] inserctionSortStrings(String[] v) {
        for (int i = 1; i < v.length; i++) {
            String chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].compareTo(chave) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
        return v;
    }

    public static double[] inserctionSortDoubles(double[] v) {
        for (int i = 1; i < v.length; i++) {
            double chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
        return v;
    }




    //Variações com funções extras
    public static int[] inserctionSortSteps(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
            System.out.println("Passo " + i +": " + Arrays.toString(v));
        }
        return v;
    }

    public static int[] inserctionReverseSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] < chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
        return v;
    }

    //Implementações para exercicíos que pedem entrada do user
    public static void exercicio3() {
        Scanner scanner = new Scanner(System.in);
        int[] userInputs = new int[8];
        System.out.println("Digite 8 números inteiros:");
        for (int i = 0; i < userInputs.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            userInputs[i] = scanner.nextInt();
        }
        System.out.println("Vetor original: " + Arrays.toString(userInputs));
        Inserction_Sort inserctionSortobj = new Inserction_Sort();
        int[] sortedInputs =  inserctionSortobj.inserctionSort(userInputs);
        System.out.println("Vetor ordenado: " + Arrays.toString(sortedInputs));
    }

    public static void exercicio9() {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[6];
        System.out.println("Digite as notas de 6 alunos:");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota do aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        System.out.println("Notas originais: " + Arrays.toString(notas));
        double[] sortedNotas = inserctionSortDoubles(notas); // Reutilizando seu método
        System.out.println("Notas ordenadas: " + Arrays.toString(sortedNotas));
    }

    //Implementações para o exercicío 7

    public static int[] selectionSort(int[] vetor) {
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
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
        }
        return vetor;
    };

    public static void exercicio7() {

        Random random = new Random();
        int[] vetorOriginal = new int[1000];
        //Preenchendo o vetor de teste com 1000 números aleatórios
        for (int i = 0; i < 1000; i++) {
            vetorOriginal[i] = random.nextInt(1000);
        }
        //Teste Selection
        int[] copiaParaSelection = vetorOriginal.clone();
        long startTimeSelection = System.nanoTime();
        selectionSort(copiaParaSelection);
        long endTimeSelection = System.nanoTime();
        long durationSelection = (endTimeSelection - startTimeSelection) / 1_000_000;
        System.out.println("Selection Sort:    " + durationSelection + " ms");

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




