package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;
import org.apache.commons.lang.NotImplementedException;

import java.io.*;
import java.util.*;

public class MochilaDinamica implements Mochila {

    @Override
    public List<Item> calculaItensParaMochila(MochilaInfo mochilaInfo) {
        final var itens = mochilaInfo.itens();
        final var capacidadeMochila = mochilaInfo.capacidadeMochila();

        var tabelaEstados = new double[itens.size() + 1][capacidadeMochila.intValue() + 1];

        for (int i = 0; i <= itens.size(); i++) {
            for (int j = 0; j <= capacidadeMochila; j++) {
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

        var totalValor = tabelaEstados[itens.size()][capacidadeMochila.intValue()];
        throw new NotImplementedException("Not implemented yet");
    }
}