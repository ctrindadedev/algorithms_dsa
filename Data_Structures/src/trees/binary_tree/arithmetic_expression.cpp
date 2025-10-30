#include <iostream>
#include <string>
#include <stack>    
#include <sstream> 

struct Node {
    std::string data;
    Node *left;
    Node *right;

    // Construtor
    Node(std::string value) : data(value), left(nullptr), right(nullptr) {}

    // Destrutor 
    ~Node() {
        delete left;
        delete right;
    }
};

bool isOperator(const std::string& input) {
    return input == "+" || input == "-" || input == "*" || input == "/";
}

Node* buildExpressionTree(const std::string& expressaoPolonesa) {

    
    std::stack<Node*> nodeStack;
    std::stringstream valores(expressaoPolonesa); //Separa cada caractere da string de entrada por espaços
    std::string token;

    while (valores >> token) {
        if (!isOperator(token)) {
            nodeStack.push(new Node(token));
        } else {
            if (nodeStack.size() < 2) {
                std::cerr << "É necessário inserir pelo menos dois números antes do primeiro operador. \n";
                while(!nodeStack.empty()){
                    delete nodeStack.top();
                    nodeStack.pop();
                }
                return nullptr;
            }

            Node* rightChild = nodeStack.top();
            nodeStack.pop();

            Node* leftChild = nodeStack.top();
            nodeStack.pop();

            Node* operatorNode = new Node(token);
            
            operatorNode->left = leftChild;
            operatorNode->right = rightChild;

            nodeStack.push(operatorNode);
        }
    }
        return nodeStack.top();
}

int valorTree(Node* root) {

    if (root == nullptr) {
        std::cerr << "Árvore vazia\n";
        return 0;
    }

    // Caso base (Se o nó é uma folha então ele é um número)
    if (root->left == nullptr && root->right == nullptr) {
        return std::stoi(root->data);
    }
    //Passo recursivo
    int leftValue = valorTree(root->left);
    int rightValue = valorTree(root->right);

    if (root->data == "+") return leftValue + rightValue;
    if (root->data == "-") return leftValue - rightValue;
    if (root->data == "*") return leftValue * rightValue;
    if (root->data == "/") {
        if (rightValue == 0) {
            std::cerr << "Divisão por zero identificada\n";
            return 0; 
        }
        return leftValue / rightValue;
    }
    return 0;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << " Não há argumentos suficientes \n";
        std::cerr << "Exemplo: " << argv[0] << " 1 2 + 3 *\n";
        return 1;
    }

    std::string expression;
    for (int i = 1; i < argc; ++i) {
        expression += argv[i];
        if (i < argc - 1) {
            expression += " "; 
        }
    }

    Node* root = buildExpressionTree(expression);
    if (root != nullptr) {
        int result = valorTree(root);
        std::cout << result << std::endl;
        delete root;

    } else {
        return 1;
    }

    return 0; 
}