package ellian.aragao.github.algoritmo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BuscaBinaria extends BaseValidation {
    public <E extends Comparable<E>> Optional<E> buscaBinaria(List<E> list, E itemDeBusca) {
        if (validation(list, itemDeBusca)) return Optional.empty();
        Collections.sort(list);
        return buscaBinariaRecursiva(list, itemDeBusca);
    }

    private <E extends Comparable<E>> Optional<E> buscaBinariaRecursiva(List<E> list, E itemDeBusca) {
        final var firstItem = list.getFirst();
        final var lastItem = list.getLast();
        if (itemDeBusca.compareTo(firstItem) < 0 || itemDeBusca.compareTo(lastItem) > 0) return Optional.empty();

        final int tamanhoLista = list.size();
        final int metadeTamanhoLista = tamanhoLista / 2;

        final var itemDoMeioDaLista = list.get(metadeTamanhoLista);
        int comparacao = itemDeBusca.compareTo(itemDoMeioDaLista);
        if (comparacao < 0) {
            final var sublistaEsquerda = list.subList(0, metadeTamanhoLista);
            return buscaBinaria(sublistaEsquerda, itemDeBusca);
        } else if (comparacao > 0) {
            final var sublistaDireita = list.subList(metadeTamanhoLista, tamanhoLista);
            return buscaBinaria(sublistaDireita, itemDeBusca);
        }

        return Optional.of(itemDoMeioDaLista);
    }
}
