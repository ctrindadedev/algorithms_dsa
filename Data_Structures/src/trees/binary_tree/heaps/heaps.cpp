#include <bits/stdc++.h>

using namespace std;

int main() {

    //Max-Heap
	vector<int> v = {10, 14, 8, 4, 6, 12, 7, 5, 9, 3, 11, 16};
	priority_queue<int> pq_max(v.begin(), v.end());

    cout << "Heap Máximo: \n";
	while(!pq_max.empty()) {
		cout << pq_max.top() << " ";
		pq_max.pop();
	}
    cout << "\n";

    //Min-Heap (Metódo de usar o negativo dos números)
    vector<int> negative_v = {-10, -14, -8, -4, -6, -12, -7, -5, -9, -3, -11, -16};
	priority_queue<int> pq_min(negative_v.begin(), negative_v.end());

    cout << "Heap minimo: \n";
    while(!pq_min.empty()) {
		cout << pq_min.top() << " ";
		pq_min.pop();
	}

    cout << "\n" << "Simulador de Gerenciador de Tarefas usando Heaps: \n";
    priority_queue<pair<int, string>> pq;
	while(true) {
		cout << "Digite: (1) limpar agenda (2) inserir tarefa (3) próxima tarefa" << endl;
		int opcao;
		cin >> opcao;
		if(opcao == 1) { 
			while(!pq.empty())
				pq.pop();
		} else if(opcao == 2) { 
			cout << "Digite a descricao da tarefa: ";
			string desc;
			cin >> desc;
			cout << "Digite a prioridade da tarefa: ";
			int prioridade;
			cin >> prioridade;
			pq.push(make_pair(prioridade, desc));
		} else { //proxima tarefa
			if(!pq.empty()) {
				pair<int, string> tarefa = pq.top();
				pq.pop();
				cout << "Tarefa: " << tarefa.second << endl;
				cout << "Prioridade: " << tarefa.first << endl;
			}
		}

	}


	return 0;

}
