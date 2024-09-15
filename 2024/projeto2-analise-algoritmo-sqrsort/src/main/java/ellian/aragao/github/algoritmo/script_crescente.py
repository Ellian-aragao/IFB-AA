import matplotlib.pyplot as plt
import numpy as np

# Dados atualizados
entradas = [10**4, 10**5, 10**6, 10**7]

# Dados crescentes para Heap
scores_crescente_heap = [2.270, 77.285, 527.000, 7761.211]
log_scores_crescente_heap = np.log10(scores_crescente_heap)

# Dados crescentes para Bubble
scores_crescente_bubble = [10.978, 373.937, 14781.964, 565984.556]
log_scores_crescente_bubble = np.log10(scores_crescente_bubble)

# Cria o gráfico
plt.figure(figsize=(12, 8))

# Linha para dados crescentes de Heap
plt.plot(entradas, log_scores_crescente_heap, marker='o', linestyle='-', color='b', label='Heap - Crescente')

# Linha para dados crescentes de Bubble
plt.plot(entradas, log_scores_crescente_bubble, marker='o', linestyle='--', color='orange', label='Bubble - Crescente')

# Define os rótulos dos eixos
plt.xlabel('Número de Entradas')
plt.ylabel('log(milissegundos)')
plt.xscale('log')  # Usa escala logarítmica para o eixo x
plt.title('Comparação de dados do Heap e Bubble')

# Adiciona a legenda
plt.legend()

# Exibe o gráfico
plt.grid(True, which='both', linestyle='--', linewidth=0.5)
plt.show()
