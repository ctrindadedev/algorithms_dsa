package java.main.Arrays;

import java.util.Scanner;

public class ArraysExercises {
    public static void main(String[] args) {
        int[] notas = {8, 6, 9, 7, 10, 4, 3, 2, 9, 10};
        String[] nomes = {"Caio", "Travis", "Augusto", "Scott", "Trindade"};


        //é ideal para leitura usar o for each
        for (int nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println("\n");

        //Exercício 1: Impressão Reversa
        System.out.println("Nomes na ordem reversa\n");
        for (int i = nomes.length - 1; i >= 0; i--) {
            System.out.print(nomes[i] + " ");
        }
        System.out.println("\n");

        //Exercício 2: Pares e Soma de Ímpares
        System.out.println("Pares e Impares \n");
        int soma = 0;
        for (int nota : notas) {
            //Imprima todos os pares
            if ((nota % 2) == 0) {
                System.out.print(nota + " ");
            }

            // Calcule e exiba soma dos ímpares
            else {
                soma += nota;
            }
        }
        System.out.println("Soma dos impares: " + soma);

        System.out.println("Analise de notas \n");


        // Exercício 3 (Desafio): Análise de Notas
        double[] notasEscola = new double[5];
        Scanner sc = new Scanner(System.in);
        double somaNotas = 0;

        //Leia as notas de 5 alunos
        for (int i = 0; i < notasEscola.length; i++) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            notasEscola[i] = sc.nextDouble();
            somaNotas += notasEscola[i];
        }

        double media = somaNotas / notasEscola.length;

        // Impressão das notas
        System.out.println("\nNotas digitadas:");
        for (double nota : notasEscola) {
            System.out.println(nota);
        }

        // Imprimir a média
        System.out.println("\nMédia geral: " + media);

        // Notas acima da média
        System.out.println("\nNotas acima da média:");
        for (double nota : notasEscola) {
            if (nota > media) {
                System.out.println(nota);
            }
        }

        sc.close();
    }
}



