#!/bin/bash

echo "=========================================="
echo "Compilando e Rodando a Solucao Lenta"
echo "=========================================="
g++ BadSolutionCopy.cpp -o bad_solver
if [ $? -eq 0 ]; then
    ./bad_solver
else
    echo "Erro na compilação do BadSolutionCopy.cpp"
    exit 1
fi

echo ""
echo "=========================================="
echo "Compilando e Rodando a Solucao Otimizada"
echo "=========================================="
g++ GoodSolutionCopy.cpp -o good_solver
if [ $? -eq 0 ]; then
    ./good_solver
else
    echo "Erro na compilação do GoodSolutionCopy.cpp"
    exit 1
fi

echo ""
echo "=========================================="
echo "Configurando Ambiente Python (VENV)"
echo "=========================================="

if [ ! -d ".venv" ]; then
    echo "Criando ambiente virtual..."
    $PYTHON_CMD -m venv .venv
fi

# Ativa o ambiente virtual
. .venv/bin/activate

echo "Instalando bibliotecas necessarias"
pip install -r requirements.txt -q

echo ""
echo "=========================================="
echo "Gerando o Grafico"
echo "=========================================="

python graphic.py

# Desativa o ambiente (boa prática)
deactivate

echo ""
echo "Concluido! Verifique o arquivo 'comparacao_algoritmos.png'."




echo ""
echo "Geração do gráfico concluido"