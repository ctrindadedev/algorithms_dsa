#include <iostream>
#include <memory>           
#include <initializer_list> 

using namespace std;

class No {
public:
    int chave;
    std::shared_ptr<No> esquerda;
    std::shared_ptr<No> direita;

    No(int c) : chave(c), esquerda(nullptr), direita(nullptr) {}
};

std::shared_ptr<No> search(int value, std::shared_ptr<No> node) {
    // Caso Base 1: Nó não encontrado (árvore vazia)
    if (node == nullptr) {
        return nullptr;
    }

    // Caso Base 2: Nó encontrado
    if (node->chave == value) {
        return node;
    }
    // Passo Recursivo: Procura na sub-árvore correta
    else if (value < node->chave) {
        return search(value, node->esquerda);
    } 
    else { 
        return search(value, node->direita);
    }
}


// Percurso em ordem (Esquerda, Raiz, Direita)
void emOrdem(const std::shared_ptr<No>& raiz) {
    if (!raiz) return;
    emOrdem(raiz->esquerda);
    cout << raiz->chave << " ";
    emOrdem(raiz->direita);
}

// Percurso Pré-Ordem (Raiz, Esquerda, Direita)
void preOrdem(const std::shared_ptr<No>& raiz) {
    if (!raiz) return;
    cout << raiz->chave << " ";
    preOrdem(raiz->esquerda);
    preOrdem(raiz->direita);
}

// Percurso Pós-Ordem (Esquerda, Direita, Raiz)
void posOrdem(const std::shared_ptr<No>& raiz) {
    if (!raiz) return;
    posOrdem(raiz->esquerda);
    posOrdem(raiz->direita);
    cout << raiz->chave << " ";
}


std::shared_ptr<No> encontrarMinimo(std::shared_ptr<No> raiz) {
    auto atual = raiz;
    while (atual && atual->esquerda)
        atual = atual->esquerda;
    return atual;
}

std::shared_ptr<No> encontrarMaximo(std::shared_ptr<No> raiz) {
    auto atual = raiz;
    while (atual && atual->direita)
        atual = atual->direita;
    return atual;
}

std::shared_ptr<No> sucessor(std::shared_ptr<No> root, int value) {
    auto current = search(value, root);
    if (!current) return nullptr;

    if (current->direita)
        return encontrarMinimo(current->direita);

    std::shared_ptr<No> succ = nullptr;
    auto ancestor = root;
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

std::shared_ptr<No> predecessor(std::shared_ptr<No> root, int value) {
    auto current = search(value, root);
    if (!current) return nullptr;

    if (current->esquerda)
        return encontrarMaximo(current->esquerda);

    std::shared_ptr<No> pred = nullptr;
    auto ancestor = root;
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


// Note que elas agora RETORNAM o nó da sub-árvore modificada.

std::shared_ptr<No> inserir(std::shared_ptr<No> raiz, int chave) {
    if (raiz == nullptr) {
        return std::make_shared<No>(chave);
    }
    if (chave < raiz->chave) {
        raiz->esquerda = inserir(raiz->esquerda, chave);
    } else if (chave > raiz->chave) {
        raiz->direita = inserir(raiz->direita, chave);
    }
    return raiz;
}

std::shared_ptr<No> remover(std::shared_ptr<No> raiz, int chave) {
    if (raiz == nullptr) return nullptr;

    if (chave < raiz->chave) {
        raiz->esquerda = remover(raiz->esquerda, chave);
    } else if (chave > raiz->chave) {
        raiz->direita = remover(raiz->direita, chave);
    } else {
        
        // Caso 1: folha (ou somente filho direito)
        if (!raiz->esquerda) {
            return raiz->direita;
        } 
        // Caso 2b: somente filho esquerdo
        else if (!raiz->direita) {
            return raiz->esquerda;
        } 
        // Caso 3: dois filhos
        else {
            std::shared_ptr<No> sucessor = encontrarMinimo(raiz->direita);
            raiz->chave = sucessor->chave;
            // Remove o nó sucessor da sub-árvore direita
            raiz->direita = remover(raiz->direita, sucessor->chave);
        }
    }
    return raiz;
}


std::shared_ptr<No> construirArvore(std::initializer_list<int> chaves) {
    std::shared_ptr<No> raiz = nullptr;
    for (int c : chaves)
        raiz = inserir(raiz, c); 
    return raiz;
}

int main() {
    std::shared_ptr<No> raiz = construirArvore({8, 3, 10, 1, 6, 14, 4, 7, 13});
    /* Árvore inicial:
              8
           /     \
          3       10
         / \        \
        1   6        14
           / \      /
          4   7    13
    */


    cout << "Pre-Ordem: "; preOrdem(raiz); cout << endl;
    cout << "Em-Ordem:  "; emOrdem(raiz); cout << endl;
    cout << "----------------------------------" << endl;

    // CASO 1: REMOVER UM NÓ FOLHA(4)
    cout << "Removendo 4 (Caso 1: No Folha)" << endl;
    remover(raiz, 4);
    /* Árvore esperada:
              8
           /     \
          3       10
         / \        \
        1   6        14
             \      /
              7    13 
    */
    cout << "Pre-Ordem: "; preOrdem(raiz); cout << endl;
    cout << "Em-Ordem:  "; emOrdem(raiz); cout << endl;
    cout << "----------------------------------" << endl;

    // CASO 2: Remover nó com filho (nó 10 -> tem o  filho 14)
    cout << "Removendo 10 (Caso 2: 1 Filho)" << endl;
    remover(raiz, 10);
    /* Árvore esperada:
              8
           /     \
          3       14
         / \      /
        1   6    13
             \      
              7     
    */
    cout << "Pre-Ordem: "; preOrdem(raiz); cout << endl;
    cout << "Em-Ordem:  "; emOrdem(raiz); cout << endl;
    cout << "----------------------------------" << endl;

    // CASO 3: REMOVER UM NÓ COM DOIS FILHOS (o nó 3 -> tem 2 filhos, 1 e 6)
    cout << "Removendo 3 (Caso 3: 2 Filhos)" << endl;
    // Lógica:
    // 1. Sucessor de 3 é o mínimo da sub-árvore direita de 3 (o nó '6')
    // 2. O valor 6 é copiado para o nó 3.
    // 3. A remoção de '6' é chamada na sub-árvore (que vira um Caso 2, com 1 filho '7')
    remover(raiz, 3);
    /* Árvore esperada:
              8
           /     \
          6       14
         / \      /
        1   7    13
    */
    cout << "Pre-Ordem: "; preOrdem(raiz); cout << endl;
    cout << "Em-Ordem:  "; emOrdem(raiz); cout << endl;
    cout << "----------------------------------" << endl;
    
    cout << "Removendo 8 (a raiz)...\n";
    raiz = remover(raiz, 8); 

    cout << "Pre-Ordem: "; preOrdem(raiz); cout << endl;
    cout << "Em-Ordem:  "; emOrdem(raiz); cout << endl;
    cout << "\n";
    return 0;
}