package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;

import java.util.LinkedList;
import java.util.List;

public class MochilaGulosaValorCusto implements Mochila {
    
    @Override
    public List<Item> calculaItensParaMochila(MochilaInfo mochilaInfo) {
        // Definição dos itens (weight e valor)
        final var itens = mochilaInfo.itens();

        // Definição da capacidade da mochila
        final var capacidadeMochila = mochilaInfo.capacidadeMochila();

        // Inicialização do conjunto de itens na mochila
        boolean[] itensNaMochila = new boolean[itens.size()];

        // Algoritmo guloso (priorizando pelo valor/custo)
        for (int i = 0; i < itens.size(); i++) {
            if (!itensNaMochila[i]) {
                int totalPeso = getTotalPeso(itensNaMochila, itens);
                if (totalPeso + itens.get(i).weight() <= capacidadeMochila) {
                    double valorCusto = itens.get(i).value() / itens.get(i).weight();
                    boolean encontrado = false;
                    for (int j = 0; j < i && !encontrado; j++) {
                        if (!itensNaMochila[j] && itens.get(j).value() / itens.get(j).weight() >= valorCusto) {
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        itensNaMochila[i] = true;
                    }
                }
            }
        }

        final var itensFinais = new LinkedList<Item>();
        for (int i = 0; i < itens.size(); i++) {
            if (!itensNaMochila[i]) continue;
            itensFinais.add(itens.get(i));
        }

        return itensFinais;
    }

    private static int getTotalPeso(boolean[] itensNaMochila, List<Item> itens) {
        int totalPeso = 0;
        for (int i = 0; i < itens.size(); i++) {
            if (itensNaMochila[i]) {
                totalPeso += itens.get(i).weight();
            }
        }
        return totalPeso;
    }

    private static int getTotalValor(boolean[] itensNaMochila, List<Item> itens) {
        int totalValor = 0;
        for (int i = 0; i < itens.size(); i++) {
            if (itensNaMochila[i]) {
                totalValor += itens.get(i).value();
            }
        }
        return totalValor;
    }
}
