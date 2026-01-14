#include <iostream>
#include <vector>
#include <chrono>
#include <fstream>
#include <random>

using namespace std;
using namespace std::chrono;

// Configurações do teste
const int Q_FIXO = 1000; // Número fixo de queries para testar o peso do N
const int MAX_VAL = 100000;

int main() {
    ofstream csvFile("bad.csv");
    csvFile << "N,Tempo_ms\n"; // Cabeçalho do CSV

    // Loop de teste: N de 5 até 150 (Acima disso N^3 fica muito lento)
    for (int n = 5; n <= 150; n += 5) {
        
        // 1. Gerar dados aleatórios para tamanho N
        vector<int> A(n), B(n), C(n), X(Q_FIXO);
        for(int &x : A) x = rand() % MAX_VAL;
        for(int &x : B) x = rand() % MAX_VAL;
        for(int &x : C) x = rand() % MAX_VAL;
        for(int &x : X) x = rand() % (MAX_VAL * 3);

        // 2. Medir tempo do algoritmo RUIM
        auto start = high_resolution_clock::now();
        
        int dummy_count = 0; // Para evitar otimização do compilador
        for (int i = 0; i < Q_FIXO; ++i) {
            bool found = false;
            int target = X[i];
            
            // Lógica O(N^3) repetida Q vezes
            for (int a : A) {
                for (int b : B) {
                    for (int c : C) {
                        if (a + b + c == target) {
                            found = true;
                            goto end_loops;
                        }
                    }
                }
            }
            end_loops:
            if(found) dummy_count++;
        }

        auto stop = high_resolution_clock::now();
        auto duration = duration_cast<milliseconds>(stop - start);

        cout << "Ruim - N: " << n << " | Tempo: " << duration.count() << "ms" << endl;
        csvFile << n << "," << duration.count() << "\n";
    }

    csvFile.close();
    return 0;
}