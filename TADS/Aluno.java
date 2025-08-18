package TADS;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int matricula;
    private ArrayList<Double> notas = new ArrayList<>();

    public void adicionarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        if (nota >= 0 && nota <= 10) {
            notas.add(nota);
        }
    }
    public double calcularMedia() {
            double soma = 0;
            for (double  n : notas) soma += n;
            return notas.size() > 0 ? soma / notas.size() : 0;
        }

    public boolean verificarAprovacao() {
            return calcularMedia() >= 7.0;
        }

    }

