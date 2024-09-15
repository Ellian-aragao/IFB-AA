package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;

import java.util.LinkedList;
import java.util.List;

public class MochilaGulosaPeso implements Mochila {
    @Override
    public List<Item> calculaItensParaMochila(MochilaInfo mochilaInfo) {
        final var itens = mochilaInfo.itens();

        // Definição da capacidade da mochila
        int capacidadeMochila = 10;

        // Inicialização do conjunto de itens na mochila
        boolean[] itensNaMochila = new boolean[itens.size()];

        // Algoritmo guloso (priorizando pelo weight)
        for (int i = 0; i < itens.size(); i++) {
            if (!itensNaMochila[i]) {
                int totalPeso = get_total_peso(itensNaMochila, itens);
                if (totalPeso + itens.get(i).weight() <= capacidadeMochila) {
                    itensNaMochila[i] = true;
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

    private static int get_total_peso(boolean[] itensNaMochila, List<Item> itens) {
        int totalPeso = 0;
        for (int i = 0; i < itens.size(); i++) {
            if (itensNaMochila[i]) {
                totalPeso += itens.get(i).weight();
            }
        }
        return totalPeso;
    }

    private static int get_total_valor(boolean[] itensNaMochila, List<Item> itens) {
        int totalValor = 0;
        for (int i = 0; i < itens.size(); i++) {
            if (itensNaMochila[i]) {
                totalValor += itens.get(i).weight();
            }
        }
        return totalValor;
    }
}
