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
            List<E> subList = collection.subList(i, fim);
            executeSort(subList);
            collectionOfCollection.add(subList);
        }

        while (!collectionOfCollection.isEmpty()) {
            E maior = null;
            var index = 0;
            List<E> removerLista = null;

            for (final var subListaOrdenada : collectionOfCollection) {
                if (subListaOrdenada.isEmpty()) break;

                final var atualElemento = subListaOrdenada.getLast();
                if (!Objects.isNull(maior) && atualElemento.compareTo(maior) <= 0) continue;

                maior = atualElemento;
                removerLista = subListaOrdenada;
            }
            System.out.println(maior);

            if (Objects.nonNull(maior)) {
                finalCollection.set(finalCollection.size() - 1, maior);
                removerLista.removeLast();
            }

            collectionOfCollection.removeIf(List::isEmpty);
        }

        return finalCollection;
    }

    protected abstract <E extends Comparable<E>> List<E> executeSort(List<E> list);
}
