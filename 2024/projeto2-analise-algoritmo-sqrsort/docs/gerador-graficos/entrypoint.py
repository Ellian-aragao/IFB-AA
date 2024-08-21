import matplotlib.pyplot as plt
import csv

rootcsv = '/home/ellian/code/faculdade/IFB-AA/2024/projeto2-analise-algoritmo-sqrsort/docs/csv'
filenamepath = f'{rootcsv}/bubble/bubble-aleatorio.csv'

if __name__ == '__main__':
    tamanhoEntradas = []
    tempoSegundosPorOperacao = []
    tempoMargemDeErro = []

    with open(filenamepath) as csvfile:
        spamreader = csv.reader(csvfile, delimiter=',')

        for row in spamreader:
            if len(row) <= 0 or row[0] == 'Entrada':
                continue

            tamanhoEntradas.append(int(row[0]))
            tempoSegundosPorOperacao.append(float(row[1]))
            tempoMargemDeErro.append(float(row[2]))


    fig, ax = plt.subplots()
    ax.plot(tempoSegundosPorOperacao, tamanhoEntradas)
    print(tempoSegundosPorOperacao)

    ax.set(xlabel='Segundos/Operação', ylabel='Quantidade de Entradas',
           )
    ax.grid()

    fig.savefig("test.png")
    # plt.show()
