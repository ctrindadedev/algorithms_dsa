#include <iostream>
#include <vector>
#include <algorithm>
#include <chrono>
#include <fstream>
#include <random>

using namespace std;
using namespace std::chrono;

const int Q_FIXO = 1000; 
const int MAX_VAL = 100000;

int main() {
    ofstream csvFile("good.csv");
    csvFile << "N,Tempo_ms\n"; 

    // Loop de teste igual ao anterior
    for (int n = 5; n <= 150; n += 5) {
        
        vector<int> A(n), B(n), C(n), X(Q_FIXO);
        for(int &x : A) x = rand() % MAX_VAL;
        for(int &x : B) x = rand() % MAX_VAL;
        for(int &x : C) x = rand() % MAX_VAL;
        for(int &x : X) x = rand() % (MAX_VAL * 3);

        // 2. Medir tempo do algoritmo BOM
        auto start = high_resolution_clock::now();
        
        // Pré-processamento O(N^3) executado APENAS UMA VEZ
        vector<int> sums;
        sums.reserve(n * n * n);
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    sums.push_back(a + b + c);
                }
            }
        }
        sort(sums.begin(), sums.end());
        auto last = unique(sums.begin(), sums.end());
        sums.erase(last, sums.end());

        // Queries em O(log S)
        int dummy_count = 0;
        for (int i = 0; i < Q_FIXO; ++i) {
            if (binary_search(sums.begin(), sums.end(), X[i])) {
                dummy_count++;
            }
        }

        auto stop = high_resolution_clock::now();
        auto duration = duration_cast<milliseconds>(stop - start);

        cout << "Bom  - N: " << n << " | Tempo: " << duration.count() << "ms" << endl;
        csvFile << n << "," << duration.count() << "\n";
    }

    csvFile.close();
    return 0;
}