import matplotlib.pyplot as plt
import numpy as np

entradas = [10**4, 10**5, 10**6, 10**7]

# Dados aleatórios
scores_aleatoria = [13.907, 473.859, 23745.766, 1016637.053]
log_scores_aleatoria = np.log10(scores_aleatoria)

# Dados crescentes
scores_crescente = [10.978, 373.937, 14781.964, 565984.556]
log_scores_crescente = np.log10(scores_crescente)

# Dados decrescentes
scores_decrescente = [13.178, 448.658, 18304.992, 691633.787]
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
