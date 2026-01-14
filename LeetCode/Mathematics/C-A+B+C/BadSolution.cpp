#include <iostream>
#include <vector>

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

    // Processamento das entradas de X
    for (int i = 0; i < Q; ++i) {
        bool found = false;
        int target = X[i];

        // 3 loops aninhados para cada query (Isso causa o time limit)
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
        if (found) cout << "Yes\n";
        else cout << "No\n";
    }

    return 0;
}