package ellian.aragao.github.algoritmo;

import java.util.*;

public class BuscaSequencial extends BaseValidation {
    public <E> Optional<E> buscaSequencial(Collection<E> collection, E itemDeBusca) {
        if (validation(collection, itemDeBusca)) return Optional.empty();

        for (E proximoItem : collection) {
            if (proximoItem.equals(itemDeBusca)) return Optional.of(proximoItem);
        }

        return Optional.empty();
    }

    public <E extends Comparable<E>> Optional<E> buscaSequencialOtimizada(List<E> collection, E itemDeBusca) {
        if (validation(collection, itemDeBusca)) return Optional.empty();

        Collections.sort(collection);

        final var firstItem = collection.getFirst();
        final var lastItem = collection.getLast();
        if (itemDeBusca.compareTo(firstItem) < 0 || itemDeBusca.compareTo(lastItem) > 0) return Optional.empty();

        for (E proximoItem : collection) {
            if (proximoItem.equals(itemDeBusca)) return Optional.of(proximoItem);
            if (proximoItem.compareTo(itemDeBusca) > 0) break;
        }

        return Optional.empty();
    }
}
