import matplotlib.pyplot as plt
import numpy as np

# Dados atualizados
entradas = [10**4, 10**5, 10**6, 10**7]

# Dados aleatórios para Heap
scores_aleatoria = [3.070, 104.539, 2087.055, 44379.352]
log_scores_aleatoria = np.log10(scores_aleatoria)

# Dados crescentes para Heap
scores_crescente = [2.270, 77.285, 527.000, 7761.211]
log_scores_crescente = np.log10(scores_crescente)

# Dados decrescentes para Heap
scores_decrescente = [2.190, 74.607, 509.685, 7315.598]
log_scores_decrescente = np.log10(scores_decrescente)

# Cria o gráfico
plt.figure(figsize=(12, 8))

# Linha para dados aleatórios
plt.plot(entradas, log_scores_aleatoria, marker='o', linestyle='-', color='b', label='Aleatório')

# Linha para dados crescentes
plt.plot(entradas, log_scores_crescente, marker='o', linestyle='--', color='g', label='Crescente')

# Linha para dados decrescentes
plt.plot(entradas, log_scores_decrescente, marker='o', linestyle='-.', color='r', label='Decrescente')

# Define os rótulos dos eixos
plt.xlabel('Número de Entradas')
plt.ylabel('log(milissegundos)')
plt.xscale('log')  # Usa escala logarítmica para o eixo x
plt.title('Gráfico de Log(milissegundos) em função do Número de Entradas')

# Adiciona a legenda
plt.legend()

# Exibe o gráfico
plt.grid(True, which='both', linestyle='--', linewidth=0.5)
plt.show()
