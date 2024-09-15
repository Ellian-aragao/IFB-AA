import matplotlib.pyplot as plt
import numpy as np

# Dados atualizados
entradas = [10**4, 10**5, 10**6, 10**7]

# Dados decrescentes para Heap
scores_decrescente_heap = [2.190, 74.607, 509.685, 7315.598]
log_scores_decrescente_heap = np.log10(scores_decrescente_heap)

# Dados decrescentes para Bubble
scores_decrescente_bubble = [13.178, 448.658, 18304.992, 691633.787]
log_scores_decrescente_bubble = np.log10(scores_decrescente_bubble)

# Cria o gráfico
plt.figure(figsize=(12, 8))

# Linha para dados decrescentes de Heap
plt.plot(entradas, log_scores_decrescente_heap, marker='o', linestyle='-', color='b', label='Heap - Decrescente')

# Linha para dados decrescentes de Bubble
plt.plot(entradas, log_scores_decrescente_bubble, marker='o', linestyle='--', color='orange', label='Bubble - Decrescente')

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
