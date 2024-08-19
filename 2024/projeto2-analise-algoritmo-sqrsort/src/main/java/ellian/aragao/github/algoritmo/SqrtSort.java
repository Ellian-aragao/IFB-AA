package ellian.aragao.github.algoritmo;

import java.util.*;

public abstract class SqrtSort {

    public <E extends Comparable<E>> List<E> sqrtSort(List<E> collection) {
        final int sizeCollection = collection.size();
        final int intSize = (int) Math.sqrt(sizeCollection);
        final var finalCollection = new ArrayList<E>(sizeCollection);
        final var collectionOfCollection = new ArrayList<List<E>>();

        for (int i = 0; i < sizeCollection; i += intSize) {
            final var fim = Math.min(i + intSize, sizeCollection);
            final var subList = new ArrayList<>(collection.subList(i, fim));
            executeSort(subList);
            collectionOfCollection.add(subList);
        }

        while (!collectionOfCollection.isEmpty()) {
            E menor = null;
            List<E> removerLista = null;

            for (final var subListaOrdenada : collectionOfCollection) {
                if (subListaOrdenada.isEmpty()) break;

                final var atualElemento = subListaOrdenada.getFirst();
                if (!Objects.isNull(menor) && atualElemento.compareTo(menor) >= 0) continue;

                menor = atualElemento;
                removerLista = subListaOrdenada;
            }

            if (Objects.nonNull(menor)) {
                finalCollection.add(menor);
                removerLista.removeFirst();
            }

            collectionOfCollection.removeIf(List::isEmpty);
        }

        return finalCollection;
    }

    protected abstract <E extends Comparable<E>> List<E> executeSort(List<E> list);
}
