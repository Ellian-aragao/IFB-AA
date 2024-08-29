import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

# Leitura dos dados a partir do CSV
data = pd.read_csv('teste2.csv')

# Extrair colunas
entrada = data['Entrada']
algoritmo = data['Algoritmo']
milissegundos = data['microsegundos']
margem_erro = data['MargemErro']

# Adicionar algoritmo n*sqrt(n)
n_values = {'aleatoria': 10000, 'crecente': 10000, 'decrecente': 10000}
sqrt_n_times = [0.5 * n_values[e]**0.5 for e in entrada]
new_milissegundos = pd.Series(sqrt_n_times)
new_margem_erro = pd.Series([0.05 * t for t in sqrt_n_times])
new_algoritmo = pd.Series(['n*sqrt(n)'] * len(entrada))
new_entrada = entrada.copy()

# Debug: Verificar os valores calculados
print("Valores de n*sqrt(n):", new_milissegundos)

# Concatenando os novos dados
milissegundos = pd.concat([milissegundos, new_milissegundos], ignore_index=True)
margem_erro = pd.concat([margem_erro, new_margem_erro], ignore_index=True)
algoritmo = pd.concat([algoritmo, new_algoritmo], ignore_index=True)
entrada = pd.concat([entrada, new_entrada], ignore_index=True)

# Debug: Verificar os valores finais
print("Milissegundos:", milissegundos)
print("Margem de Erro:", margem_erro)

# Configuração do gráfico
fig, ax = plt.subplots()

# Agrupando dados por algoritmo
for alg in set(algoritmo):
    x = [i for i in range(len(entrada)) if algoritmo[i] == alg]
    y = [milissegundos[i] for i in range(len(entrada)) if algoritmo[i] == alg]
    yerr = [margem_erro[i] for i in range(len(entrada)) if algoritmo[i] == alg]
    ax.errorbar(x, y, yerr=yerr, fmt='o', label=alg, capsize=5)

# Configurações do eixo
ax.set_yscale('log')
ax.set_ylim([min(milissegundos) * 0.8, max(milissegundos) * 1.2])  # Ajuste da escala y
ax.set_xticks(np.arange(len(entrada) // len(set(algoritmo))))
ax.set_xticklabels(entrada[:len(entrada) // len(set(algoritmo))])
ax.set_xlabel('Entrada')
ax.set_ylabel('Milissegundos por Operação (escala logarítmica)')
ax.set_title('Desempenho dos Algoritmos em Diferentes Entradas')
ax.legend()

# Mostrar gráfico
plt.show()
