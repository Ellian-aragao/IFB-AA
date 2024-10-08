package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;

import java.util.LinkedList;
import java.util.List;

public class MochilaDinamica implements Mochila {

    @Override
    public List<Item> calculaItensParaMochila(MochilaInfo mochilaInfo) {
        final var itens = mochilaInfo.itens();
        final var capacidadeMochila = mochilaInfo.capacidadeMochila();

        var tabelaEstados = new double[itens.size() + 1][capacidadeMochila.intValue() + 1];

        for (int i = 0; i <= itens.size(); i++) {
            for (int j = 0; j <= capacidadeMochila.intValue(); j++) {
                if (i == 0 || j == 0) {
                    tabelaEstados[i][j] = 0;
                } else {
                    var valorSemItens = tabelaEstados[i - 1][j];
                    var pesoItemAtual = itens.get(i - 1).weight().intValue();
                    if (pesoItemAtual <= j) {
                        var valorComItens = itens.get(i - 1).value() + tabelaEstados[i - 1][j - pesoItemAtual];
                        tabelaEstados[i][j] = Math.max(valorSemItens, valorComItens);
                    } else {
                        tabelaEstados[i][j] = valorSemItens;
                    }
                }
            }
        }

        List<Item> itensSelecionados = new LinkedList<>();
        int capacidadeRestante = capacidadeMochila.intValue();
        for (int i = itens.size(); i > 0 && capacidadeRestante > 0; i--) {
            if (tabelaEstados[i][capacidadeRestante] != tabelaEstados[i - 1][capacidadeRestante]) {
                itensSelecionados.add(itens.get(i - 1));
                capacidadeRestante -= itens.get(i - 1).weight().intValue();
            }
        }
        return itensSelecionados;
    }
}