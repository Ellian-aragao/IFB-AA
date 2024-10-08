package ellian.aragao.github.algoritmo.sort;

import ellian.aragao.github.algoritmo.Mochila;
import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MochilaGulosaPeso2 implements Mochila {
    @Override
    public List<Item> calculaItensParaMochila(MochilaInfo mochilaInfo) {
        final var capacidadeMochila = mochilaInfo.capacidadeMochila();
        final var listaPeso = new ArrayList<>(mochilaInfo.itens());

        listaPeso.sort(Comparator.comparing(Item::weight));

        final var listaFinalItens = new LinkedList<Item>();
        var pesoMochilaFinal = 0.0;

        for (final var indexAndItem : listaPeso) {
            if (pesoMochilaFinal + indexAndItem.weight() > capacidadeMochila) break;
            listaFinalItens.add(indexAndItem);
            pesoMochilaFinal += indexAndItem.weight();
        }

        return listaFinalItens;
    }
}
