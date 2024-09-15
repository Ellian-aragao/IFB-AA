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

# Dados crescentes para Heap
scores_crescente_heap = [2.270, 77.285, 527.000, 7761.211]
log_scores_crescente_heap = np.log10(scores_crescente_heap)

# Dados crescentes para Bubble
scores_crescente_bubble = [10.978, 373.937, 14781.964, 565984.556]
log_scores_crescente_bubble = np.log10(scores_crescente_bubble)

# Dados decrescentes para Heap
scores_decrescente_heap = [2.190, 74.607, 509.685, 7315.598]
log_scores_decrescente_heap = np.log10(scores_decrescente_heap)

# Dados decrescentes para Bubble
scores_decrescente_bubble = [13.178, 448.658, 18304.992, 691633.787]
log_scores_decrescente_bubble = np.log10(scores_decrescente_bubble)

# Cria o gráfico
plt.figure(figsize=(12, 8))

# Linhas para dados aleatórios
plt.plot(entradas, scores_aleatoria_heap, marker='o', linestyle='-', color='b', label='Heap - Aleatório')
plt.plot(entradas, scores_crescente_heap, marker='o', linestyle='-', color='g', label='Heap - Crescente')
plt.plot(entradas, scores_decrescente_heap, marker='o', linestyle='-', color='r', label='Heap - Decrescente')

# Linhas para dados crescentes
plt.plot(entradas, scores_aleatoria_bubble, marker='o', linestyle='--', color='orange', label='Bubble - Aleatório')
plt.plot(entradas, scores_crescente_bubble, marker='o', linestyle='--', color='purple', label='Bubble - Crescente')
plt.plot(entradas, scores_decrescente_bubble, marker='o', linestyle='--', color='brown', label='Bubble - Decrescente')

# Linhas para dados decrescentes

# Define os rótulos dos eixos
plt.xlabel('Número de Entradas')
plt.ylabel('log(milissegundos)')
plt.yscale('log')
plt.xscale('log')  # Usa escala logarítmica para o eixo x
plt.title('Comparação de dados do Heap e Bubble')

# Adiciona a legenda
plt.legend()

# Exibe o gráfico
plt.grid(True, which='both', linestyle='--', linewidth=0.5)
plt.show()
