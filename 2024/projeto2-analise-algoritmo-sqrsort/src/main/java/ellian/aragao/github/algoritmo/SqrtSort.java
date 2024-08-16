package ellian.aragao.github.algoritmo;

import java.util.*;

public abstract class SqrtSort {

    private <E> boolean validation(List<E> collection) {
        return Objects.isNull(collection)
                || collection.isEmpty();
    }

    public <E extends Comparable<E>> List<E> sqrtSort(List<E> collection) {

        final int sizeCollection = collection.size();
        final int intSize = (int) Math.sqrt(sizeCollection);
        final List<E> finalCollection = new ArrayList<>(sizeCollection);
        final List<List<E>> collectionOfCollection = new ArrayList<>();

        for (int i = 0; i < sizeCollection; i += intSize) {
            int fim = Math.min(i + intSize, sizeCollection);
            List<E> subList = new ArrayList<>(collection.subList(i, fim));
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
