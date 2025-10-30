#include <iostream>

using namespace std;

class No {
public:
    int chave;
    No* esquerda;
    No* direita;

    No(int c) : chave(c), esquerda(nullptr), direita(nullptr) {}
};

No *search(int value, No* &node)
{
    if (node->chave == value)
    {
        return node;
    }
    else if (node->chave > value)
    {
        return search(value, node->esquerda);
    }
    else if (node->chave < value)
    {
        return search(value, node->direita);
    }

    return nullptr;
}

// Percurso em ordem (Esquerda, Raiz, Direita)
void emOrdem(const No* raiz) {
    if (!raiz) return;
    emOrdem(raiz->esquerda);
    cout << raiz->chave << " ";
    emOrdem(raiz->direita);
}

// Percurso Pré-Ordem (Raiz, Esquerda, Direita)
void preOrdem(const No* raiz) {
    if (!raiz) return;
    cout << raiz->chave << " ";
    preOrdem(raiz->esquerda);
    preOrdem(raiz->direita);
}

// Percurso Pós-Ordem (Esquerda, Direita, Raiz)
void posOrdem(const No* raiz) {
    if (!raiz) return;
    posOrdem(raiz->esquerda);
    posOrdem(raiz->direita);
    cout << raiz->chave << " ";
}


// Encontra o nó com a menor chave em uma subárvore
No* encontrarMinimo(No* raiz) {
    No* atual = raiz;
    while (atual && atual->esquerda)
        atual = atual->esquerda;
    return atual;
}

// Encontra o nó com a maior chave em uma subárvore
No* encontrarMaximo(No* raiz) {
	No* atual = raiz;
    while (atual && atual->direita)
        atual = atual->direita;
    return atual;
}

// Encontra o sucessor do nó no em uma árvore com raíz em raiz
No* sucessor(No* root, int value){
    No* current = search(value, root);
    if (!current) return nullptr;

    if (current->direita)
        return encontrarMinimo(current->direita);

    No* succ = nullptr;
    No* ancestor = root;
    while (ancestor != current) {
        if (value < ancestor->chave) {
            succ = ancestor;
            ancestor = ancestor->esquerda;
        } else {
            ancestor = ancestor->direita;
        }
    }
    return succ;
}

No* predecessor(No* root, int value){
   No* current = search(value, root);
    if (!current) return nullptr;

    if (current->esquerda)
        return encontrarMaximo(current->esquerda);

    No* pred = nullptr;
    No* ancestor = root;
    while (ancestor != current) {
        if (value > ancestor->chave) {
            pred = ancestor;
            ancestor = ancestor->direita;
        } else {
            ancestor = ancestor->esquerda;
        }
    }
    return pred;
}

// Insere uma chave na árvore binária de busca
void inserir(No*& raiz, int chave) {
    if (!raiz) {
        raiz = new No(chave);
        return;
    }
    if (chave < raiz->chave) {
        inserir(raiz->esquerda, chave);
    } else if (chave > raiz->chave) {
        inserir(raiz->direita, chave);
    } else {
        // Ignora duplicatas
    }
}

// Remove uma chave da árvore binária de busca
void remover(No*& raiz, int chave) {
    if (!raiz) return;

    if (chave < raiz->chave) {
        remover(raiz->esquerda, chave);
    } else if (chave > raiz->chave) {
        remover(raiz->direita, chave);
    } else {
        // Encontrou o nó a ser removido
        if (!raiz->esquerda && !raiz->direita) {
            // Caso 1: folha
            delete raiz;
            raiz = nullptr;
        } else if (!raiz->esquerda) {
            // Caso 2a: somente filho direito
            No* tmp = raiz->direita;
            delete raiz;
            raiz = tmp;
        } else if (!raiz->direita) {
            // Caso 2b: somente filho esquerdo
            No* tmp = raiz->esquerda;
            delete raiz;
            raiz = tmp;
        } else {
            // Caso 3: dois filhos
            No* sucessor = encontrarMinimo(raiz->direita);
            raiz->chave = sucessor->chave;
            remover(raiz->direita, sucessor->chave);
        }
    }
}

// Libera toda a memória da árvore
void destruir(No*& raiz) {
    if (!raiz) return;
    destruir(raiz->esquerda);
    destruir(raiz->direita);
    delete raiz;
    raiz = nullptr;
}

// Constrói uma árvore a partir de uma lista de valores
No* construirArvore(std::initializer_list<int> chaves) {
    No* raiz = nullptr;
    for (int c : chaves)
        inserir(raiz, c);
    return raiz;
}

int main() {
    No* raiz = construirArvore({8, 3, 10, 1, 6, 14, 4, 7, 13});

    emOrdem(raiz);
    cout << "\n";

    destruir(raiz);
    return 0;
}

