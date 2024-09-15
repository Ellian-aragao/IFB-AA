import matplotlib.pyplot as plt
import numpy as np

# Dados atualizados
entradas = [10**4, 10**5, 10**6, 10**7]

# Dados aleatórios para Heap
scores_aleatoria_heap = [3.070, 104.539, 2087.055, 44379.352]
log_scores_aleatoria_heap = np.log10(scores_aleatoria_heap)

# Dados aleatórios para Bubble
scores_aleatoria_bubble = [13.907, 473.859, 23745.766, 1016637.053]
log_scores_aleatoria_bubble = np.log10(scores_aleatoria_bubble)

# Cria o gráfico
plt.figure(figsize=(12, 8))

# Linha para dados aleatórios de Heap
plt.plot(entradas, log_scores_aleatoria_heap, marker='o', linestyle='-', color='b', label='Heap - Aleatório')

# Linha para dados aleatórios de Bubble
plt.plot(entradas, log_scores_aleatoria_bubble, marker='o', linestyle='--', color='orange', label='Bubble - Aleatório')

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
