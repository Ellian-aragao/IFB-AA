package ellian.aragao.github.algoritmo;

import ellian.aragao.github.models.ResultadoBusca;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BuscaSequencialOtimizada extends BaseValidation {
    public <E extends Comparable<E>> Optional<ResultadoBusca<Long, E>> buscaSequencialOtimizadaComSort(List<E> collection, E itemDeBusca) {
        if (validation(collection, itemDeBusca)) return Optional.empty();
        Collections.sort(collection);
        return buscaSequencialOtimizada(collection, itemDeBusca);
    }

    public <E extends Comparable<E>> Optional<ResultadoBusca<Long, E>> buscaSequencialOtimizadaSemSort(List<E> collection, E itemDeBusca) {
        if (validation(collection, itemDeBusca)) return Optional.empty();
        return buscaSequencialOtimizada(collection, itemDeBusca);
    }

    private static <E extends Comparable<E>> Optional<ResultadoBusca<Long, E>> buscaSequencialOtimizada(List<E> collection, E itemDeBusca) {
        final var firstItem = collection.getFirst();
        final var lastItem = collection.getLast();
        if (itemDeBusca.compareTo(firstItem) < 0 || itemDeBusca.compareTo(lastItem) > 0) return Optional.empty();

        long index = 0;
        for (E proximoItem : collection) {
            if (proximoItem.equals(itemDeBusca)) {
                return Optional.of(ResultadoBusca.of(index, proximoItem));
            }
            if (proximoItem.compareTo(itemDeBusca) > 0) break;
            index++;
        }

        return Optional.empty();
    }
}
