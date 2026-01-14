import pandas as pd
import matplotlib.pyplot as plt

try:
    df_bad = pd.read_csv('bad.csv')
    df_good = pd.read_csv('good.csv')
except FileNotFoundError:
    print("Erro: Arquivos .csv não foram encontrados")
    exit()

plt.figure(figsize=(10, 6))

plt.plot(df_bad['N'], df_bad['Tempo_ms'], 
         label='Força Bruta (TLE)', color='red', marker='o', linestyle='--')

plt.plot(df_good['N'], df_good['Tempo_ms'], 
         label='Otimizado (STL)', color='green', marker='o', linewidth=2)

plt.title('Comparação de Performance: Força Bruta vs Otimizado', fontsize=14)
plt.xlabel('Tamanho da Entrada (N, M, L)', fontsize=12)
plt.ylabel('Tempo de Processamento (ms)', fontsize=12)
plt.grid(True, alpha=0.3)
plt.legend()

plt.savefig('comparacao_algoritmos.png')
plt.show()