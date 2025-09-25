package java.main.Arrays;

import java.util.*;

public class LinearSearch {
    //Tudo que envolve execução direta (como Scanner, System.out) deve estar dentro de um metódo, tipo o main:

    public static void main(String[] args) {

        //Por que static antes de desenvolver um metódo?
        //Métodos static pertencem à classe.
        //Métodos não-static pertencem ao objeto;



        Scanner sc = new Scanner(System.in);
//Meus inputs para testar as soluções
        int[] fiveintegers = {9, 0, 2, 1, 0};
        int[] eightintegers = {9, 0, 2, 1, 0, 3, 5, 0};
        int[] tenintegers = {9, 0, 2, 1, 0, 3, 5, 0, 0, 25};
        double[] sevenDoubles = {4.7, 6.7, 7, 7.7, 8.3, 9.1};
        String[] sixNames = {"Ana", "Caio", "Dandara", "Eugeneio", "Flavia", "Mario"};
        String[] products = {"Massa de Cuscuz", "Fermento", "Cuscuz", "Maçã"};
        int[] vetorSemOrdem = { 5, 3, 1 ,4 ,2};

        System.out.println("Digite um número:");
        int input = sc.nextInt();
        findUserInput(fiveintegers, input);
        findUserInputFirstApparence(eightintegers, input);
        findTwentyFive(tenintegers, 25);

        System.out.println("Digite um nome:");

        sc.nextLine();
        String name = sc.nextLine();

        findName(name, sixNames);
        zeroCounter(tenintegers, 0);
        findZeroPosition(tenintegers, 0);

        getAboveSeven(sevenDoubles);

        System.out.println("Digite um valor de referência:");
        double ref = sc.nextDouble();
        sumAboveInput(sevenDoubles, ref);

        getLettermProducts(products);
        findSmallerPosition(eightintegers);
    }

    // Exercício 1
    public static int findUserInput(int[] vetor, int chave) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                System.out.println("Número encontrado " + chave);
                return i;
            }
        }
        System.out.println("Número não encontrado");
        return -1;
    }


    // Exercício 2
    public static int findUserInputFirstApparence(int[] vetor, int chave) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                System.out.println("Primeira ocorrência: índice " + i);
                return i;
            }
        }
        System.out.println("Número não encontrado");
        return -1;
    }

    // Exercício 3
    public static boolean findTwentyFive(int[] vetor, int chave) {
        for (int i : vetor) {
            if (i == chave) {
                System.out.println("SIM");
                return true;
            }
        }
        System.out.println("NÃO");
        return false;
    }

    // Exercício 4
    public static boolean findName(String name, String[] names) {
        for (String n : names) {
            if (n.equalsIgnoreCase(name)) {
                System.out.println(name + " está presente na lista de nomes.");
                return true;
            }
        }
        System.out.println(name + " não está presente na lista de nomes.");
        return false;
    }

    // Exercício 5
    public static void zeroCounter(int[] vetor, int chave) {
        int counter = 0;
        for (int j : vetor) {
            if (j == chave) {
                counter++;
            }
        }
        System.out.println("O número " + chave + " foi listado " + counter + " vezes.");
    }

    // Exercício 6
    public static void findZeroPosition(int[] vetor, int chave) {
        // "Push" do JS no Java é usado assim:
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                positions.add(i);
            }
        }
        System.out.println("Posições do número " + chave + ": " + positions);
    }

    // Exercício 7
    public static double getAboveSeven(double[] vetor) {
        for (double values : vetor) {
            if (values > 7) {
                System.out.println("Primeira nota maior que 7: " + values);
                return values;
            }
        }
        System.out.println("Nenhuma nota maior que 7 encontrada.");
        return -1;
    }

    // Exercício 8
    public static int sumAboveInput(double[] vetor, double ref) {
        int sum = 0;
        for (double values : vetor) {
            if (values > ref) {
                sum += values;
            }
        }
        System.out.println("Soma dos valores maiores que " + ref + " é: " + sum);
        return sum;
    }

    // Exercício 9
    public static List<String> getLettermProducts(String[] products) {
        // Mais um uso do "Push" em Java
        List<String> result = new ArrayList<>();
        for (String product : products) {
            if (product.startsWith("M")) {
                result.add(product);
            }
        }
        System.out.println("Produtos que começam com M: " + result);
        return result;
    }

    // Exercício 10
    public static int findSmallerPosition(int[] vetor) {
        int menorIndice = 0;
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < vetor[menorIndice]) {
                menorIndice = i;
            }
        }
        System.out.println("Índice do menor valor: " + menorIndice);
        return menorIndice;
    }

}

