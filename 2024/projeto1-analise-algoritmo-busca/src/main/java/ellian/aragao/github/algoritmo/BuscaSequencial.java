package ellian.aragao.github.algoritmo;

import java.util.*;

public class BuscaSequencial {
    public <E> Optional<E> buscaSequencial(Collection<E> collection, E itemDeBusca) {
        for (E proximoItem : collection) {
            if (proximoItem.equals(itemDeBusca)) return Optional.of(proximoItem);
        }

        return Optional.empty();
    }

    public <E extends Comparable<E>> Optional<E> buscaSequencialOtimizada(List<E> collection, E itemDeBusca) {
        Collections.sort(collection);
        for (E proximoItem : collection) {
            if (proximoItem.equals(itemDeBusca)) return Optional.of(proximoItem);
            if (proximoItem.compareTo(itemDeBusca) > 0) break;
        }

        return Optional.empty();
    }
}
