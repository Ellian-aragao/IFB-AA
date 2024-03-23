package ellian.aragao.github.algoritmo;

import ellian.aragao.github.models.ResultadoBusca;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BuscaBinaria extends BaseValidation {
    public <E extends Comparable<E>> Optional<ResultadoBusca<Integer, E>> buscaBinariaComSort(List<E> list, E itemDeBusca) {
        if (validation(list, itemDeBusca)) return Optional.empty();
        Collections.sort(list);
        return buscaBinariaRecursiva(list, itemDeBusca);
    }

    public <E extends Comparable<E>> Optional<ResultadoBusca<Integer, E>> buscaBinariaSemSort(List<E> list, E itemDeBusca) {
        if (validation(list, itemDeBusca)) return Optional.empty();
        return buscaBinariaRecursiva(list, itemDeBusca);
    }

    private <E extends Comparable<E>> Optional<ResultadoBusca<Integer, E>> buscaBinariaRecursiva(List<E> list,
                                                                                                 E itemDeBusca) {
        return buscaBinariaRecursiva(list,itemDeBusca, 1L);
    }

    private <E extends Comparable<E>> Optional<ResultadoBusca<Integer, E>> buscaBinariaRecursiva(List<E> list,
                                                                                                 E itemDeBusca,
                                                                                                 Long iteracao) {
        final var firstItem = list.getFirst();
        final var lastItem = list.getLast();
        if (itemDeBusca.compareTo(firstItem) < 0 || itemDeBusca.compareTo(lastItem) > 0) return Optional.empty();

        final int tamanhoLista = list.size();
        final int metadeTamanhoLista = tamanhoLista / 2;

        final var itemDoMeioDaLista = list.get(metadeTamanhoLista);
        int comparacao = itemDeBusca.compareTo(itemDoMeioDaLista);
        if (comparacao < 0) {
            final var sublistaEsquerda = list.subList(0, metadeTamanhoLista);
            return buscaBinariaRecursiva(sublistaEsquerda, itemDeBusca, ++iteracao);
        } else if (comparacao > 0) {
            final var sublistaDireita = list.subList(metadeTamanhoLista, tamanhoLista);
            return buscaBinariaRecursiva(sublistaDireita, itemDeBusca, ++iteracao);
        }

        return Optional.of(ResultadoBusca.of(metadeTamanhoLista, itemDoMeioDaLista, iteracao));
    }
}
