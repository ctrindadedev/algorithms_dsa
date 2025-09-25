package java.main.LinkedList.LinkedListAplications;

//Solução do professor (Sem utilizar o package LinkedList)

/**
 * Desafio: Fila prioritária
 * Justificativa: SingleLinkedList. Pois nesse caso, queremos apenas navegar para frente e
 * O controle do da prioridade é feito na aplicação utilizando operadores condicionais.
 */

public class FilaPrioritaria {

    static class Paciente {
        String nome;
        int idade;
        String senha;
        Paciente proximo;

        public Paciente(String nome, int idade, String senha) {
            this.nome = nome;
            this.idade = idade;
            this.senha = senha;
            this.proximo = null;
        }
    }

    static class Fila {
        private Paciente inicio;
        private Paciente fim;

        public void inserirPaciente(Paciente paciente) {
            if (inicio == null) {
                inicio = fim = paciente;
                return;
            }

            if (paciente.idade > 60) {
                if (inicio.idade <= 60) {
                    paciente.proximo = inicio;
                    inicio = paciente;
                    return;
                }
                Paciente atual = inicio;
                while (atual.proximo != null && atual.proximo.idade > 60) {
                    atual = atual.proximo;
                }
                paciente.proximo = atual.proximo;
                atual.proximo = paciente;
                if (paciente.proximo == null) fim = paciente;
            } else {
                fim.proximo = paciente;
                fim = paciente;
            }
        }

        public void chamarProximo() {
            if (inicio == null) {
                System.out.println("Fila vazia.");
                return;
            }
            System.out.println("Chamando: " + inicio.nome + " (Senha: " + inicio.senha + ")");
            inicio = inicio.proximo;
            if (inicio == null) fim = null;
        }

        public void listarPacientes() {
            if (inicio == null) {
                System.out.println("Nenhum paciente aguardando.");
                return;
            }
            System.out.println("Pacientes aguardando:");
            Paciente atual = inicio;
            while (atual != null) {
                System.out.println("Nome: " + atual.nome + " | Idade: " + atual.idade + " | Senha: " + atual.senha);
                atual = atual.proximo;
            }
        }
    }

    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.inserirPaciente(new Paciente("Ana", 72, "P001"));
        fila.inserirPaciente(new Paciente("Joao", 45, "P002"));
        fila.inserirPaciente(new Paciente("Maria", 65, "P003"));
        fila.inserirPaciente(new Paciente("Carlos", 30, "P004"));

        fila.listarPacientes();
        System.out.println("\n--- Atendimento ---");
        fila.chamarProximo();
        fila.chamarProximo();
        System.out.println("\n--- Fila Atualizada ---");
        fila.listarPacientes();
    }
}
