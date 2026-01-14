package java.main.Arrays;

import java.util.*;

    public class BinarySearch {

        public static void main(String[] args) {
            //Tudo que envolve execução direta (como Scanner, System.out) deve estar dentro de um metódo, tipo o main:
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite um número:");
            int input = sc.nextInt();
            //"Limpar" o buffer
            sc.nextLine();
            System.out.println("Digite um nome:");
            String name = sc.nextLine();

            //Métodos não-static pertencem ao objeto;
            //Instância da minha classe
            BinarySearch obj = new BinarySearch();

            //Meus inputs para testar as soluções
            int[] tenIntegers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] twentyIntegers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 35, 40, 41, 80, 99, 1009, 20000};
            String[] names = {"Alex", "Caio", "Juan", "Magaly", "Maria", "Pedro"};
            int[] higherThanFifty = {51, 52, 55, 56, 57, 58, 59, 60};
            int[] repeteadNumbers = {7, 7, 7, 9, 9, 9, 10, 10, 10, 15, 15, 15, 15, 18, 18, 18, 20, 20, 20};
            int[] thirtyIntegers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        }


        //Exercicio 1
        public int findInput(int[] array, int target) {
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

        //Exercicio 2
        public List<Integer> showBinarySearchProgress(int[] array, int target) {
            int ini = 0, fim = array.length - 1;
            List<Integer> list = new ArrayList<>();
            while (ini <= fim) {
                int meio = (ini + fim) / 2;
                list.add(meio);
                if (array[meio] == target) {
                    System.out.println("Os passos:" + list + "foram executados");
                    return list;
                } else if (array[meio] < target) ini = meio + 1;
                else fim = meio - 1;
            }
            System.out.println("Os passos:" + list + "foram executados, mas o número não foi encontrado.");
            return list;
        }

        //Exercicio 3;
        public int findInputPosition(int[] array, int target) {
            int ini = 0, fim = array.length - 1;
            while (ini <= fim) {
                int meio = (ini + fim) / 2;
                if (array[meio] == target) {
                    System.out.println("Posição do input no vetor:" + array[meio]);
                    return array[meio];
                } else if (array[meio] < target) ini = meio + 1;
                else fim = meio - 1;
            }
            System.out.println("Valor não encontrado");
            return -1;
        }


        //Exercicio 4

        //Crie um vetor de nomes ordenados em ordem alfabética. Implemente a busca binária para localizar se nome “Maria” existe no vetor

        public int findStringInput(String[] array, String target) {

            int ini = 0, fim = array.length - 1;
            while (ini <= fim) {
                int meio = (ini + fim) / 2;
                //CompareTo em Java: Retorna 0 se igual, > 0 se a primeira string vem depois e < 0 se a primeira string vem antes;

                int compararString = array[meio].compareTo(target);
                if (compararString == 0)
                    return meio;
                else if (compararString < 0) ini = meio + 1;
                else fim = meio - 1;
            }
            return -1;
        }


        //Exercicío 5
        public int findLowestValue(int[] array) {
            int ini = 0, fim = array.length - 1;
            double lower = 0;
            while (ini <= fim) {
                int meio = (ini + fim) / 2;
                if (array[meio] <= lower && array[meio] > 50) {
                    lower = meio;
                } else if (array[meio] > lower && array[meio] > 50) ini = meio + 1;
                else fim = meio - 1;
            }
            System.out.println("Valor não encontrado");
            return -1;
        }

        //Exercicío 6
        public int findTwentyPosition(int[] array, int target) {
            int ini = 0, fim = array.length - 1;
            while (ini <= fim) {
                int meio = (ini + fim) / 2;
                if (array[meio] == target) {
                    System.out.println("Posição da primeira aparição do número 20 no vetor:" + array[meio]);
                    return array[meio];
                } else if (array[meio] < target) ini = meio + 1;
                else fim = meio - 1;
            }
            System.out.println("Valor não encontrado");
            return -1;
        }

        //Exercicío 7
        public int findTenLastPosition(int[] array, int target) {
            int ini = 0, fim = array.length - 1;
            int posicao = 0;
            while (ini <= fim) {
                int meio = (ini + fim) / 2;
                if (array[meio] == target) {
                    posicao = meio;
                    ini = meio + 1;
                } else if (array[meio] < target) ini = meio + 1;
                else fim = meio - 1;
            }
            System.out.println("A ultima posição do número 10 foi" + posicao);
            return posicao;
        }

        ;


        //Exercicío 8
        public int comparationCounter(int[] array, int target) {
            int ini = 0, fim = array.length - 1;
            int counter = 0;
            while (ini <= fim) {
                counter++;
                int meio = (ini + fim) / 2;
                if (array[meio] == target) {
                    System.out.println("Número de passos até encontrar o valor:" + counter);
                    return counter;
                } else if (array[meio] < target) ini = meio + 1;
                else fim = meio - 1;
            }
            System.out.println("Número de passos executados:" + counter);
            return counter;
        }


        //Exercicío 9
        public int getBinarySearchElementsElimineds(int[] array, int target) {
            int ini = 0, fim = array.length - 1;
            int eliminados = 0;
            while (ini <= fim) {
                int meio = (ini + fim) / 2;
                if (array[meio] == target) {
                    System.out.println("O número de elementos eliminados até achar o target foi de:" + eliminados);
                    return eliminados;
                } else if (array[meio] < target) {
                    eliminados += (meio - ini + 1);
                    ini = meio + 1;
                } else {
                    eliminados += (fim - meio + 1);
                    fim = meio - 1;
                }
            }
            System.out.println("O número de elementos eliminados foi de:" + eliminados);
            return eliminados;
        }
        // 10. Dado um vetor de strings ordenado, implemente a busca binária e imprima a quantidade de letras comparadas até encontrar (ou não) a string buscada.

        public int stringComparationCounter(String[] array, String target) {
            int ini = 0, fim = array.length - 1;
            while (ini <= fim) {
                int counter = 0;
                int meio = (ini + fim) / 2;
                int compararString = array[meio].compareTo(target);
                if (compararString == 0){
                    counter++;
                    return meio;
                }
                else if (compararString < 0) {
                    ini = meio + 1;
                    counter++;
                }
                else{
                    fim = meio - 1;
                    counter++;
                }
            }
            return -1;
        }
    }


