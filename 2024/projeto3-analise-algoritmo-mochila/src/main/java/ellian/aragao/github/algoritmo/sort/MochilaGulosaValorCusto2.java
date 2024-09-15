package ellian.aragao.github.algoritmo.sort;

import ellian.aragao.github.algoritmo.Mochila;
import ellian.aragao.github.algoritmo.models.IndexAndItem;
import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;

import java.util.*;

public class MochilaGulosaValorCusto2 implements Mochila {
    @Override
    public List<Item> calculaItensParaMochila(MochilaInfo mochilaInfo) {
        final var capacidadeMochila = mochilaInfo.capacidadeMochila();
        final var itensMochila = mochilaInfo.itens();

        final var listaPeso = new ArrayList<IndexAndItem>(capacidadeMochila.intValue());
        for (int i = 0; i < itensMochila.size(); i++) {
            listaPeso.add(new IndexAndItem(i, itensMochila.get(i)));
        }

        listaPeso.sort(Comparator.comparing(a -> a.item().value() / a.item().weight(), Collections.reverseOrder()));

        final var listaFinalItens = new LinkedList<Item>();
        var pesoMochilaFinal = 0.0;
        for (int i = 0; i < itensMochila.size() && pesoMochilaFinal <= capacidadeMochila; i++) {
            listaFinalItens.add(itensMochila.get(listaPeso.get(i).index()));
        }

        return listaFinalItens;
    }
}
