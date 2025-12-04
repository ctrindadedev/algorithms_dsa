#include <iostream>
#include <vector>
#include <algorithm> 

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N; cin >> N;
    vector<int> A(N);
    for(int &x : A) cin >> x;

    int M; cin >> M;
    vector<int> B(M);
    for(int &x : B) cin >> x;

    int L; cin >> L;
    vector<int> C(L);
    for(int &x : C) cin >> x;

    int Q; cin >> Q;
    vector<int> X(Q);
    for(int &x : X) cin >> x;

    // Pré-cálculo de todas as somas possíveis
    // Há uma restrição para o tamanho máximo ser 100 * 100 * 100 = 1.000.000
    vector<int> sums;
    sums.reserve(N * M * L); 

    for (int a : A) {
        for (int b : B) {
            for (int c : C) {
                sums.push_back(a + b + c);
            }
        }
    }

    // Permitir busca binária
    sort(sums.begin(), sums.end());
    
    // Remove duplicatas para tornar a busca ligeiramente mais eficiente
    auto last = unique(sums.begin(), sums.end());
    sums.erase(last, sums.end());

    for (int i = 0; i < Q; ++i) {
        // Retorna true se o elemento existe em O(log K)
        if (binary_search(sums.begin(), sums.end(), X[i])) {
            cout << "Yes\n";
        } else {
            cout << "No\n";
        }
    }

    return 0;
}