package ellian.aragao.github.algoritmo;

import java.lang.reflect.Array;
import java.util.*;

public class SqrtSortBubbleImpl implements SqrtSort {
    protected <E extends Comparable<E>> List<E> executeSort(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                final var compare = list.get(i).compareTo(list.get(j));
                if (compare < 0) {
                    final var tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        return list;
    }

    public <E extends Comparable<E>> List<E> sqrtSort(List<E> collection) {

        final int sizeCollection = collection.size();
        final int intSize = (int) Math.sqrt(sizeCollection);
        final var collectionOfCollection = new ArrayList<List<E>>(intSize + 1);

        for (int i = 0; i < sizeCollection; i += intSize) {
            int fim = Math.min(i + intSize, sizeCollection);
            final var subList = collection.subList(i, fim);
            executeSort(subList);
            collectionOfCollection.add(subList);
        }

        int indexFinalCollection = sizeCollection;
        @SuppressWarnings("unchecked")
        var finalCollection = (E[]) Array.newInstance(collection.getFirst().getClass(), sizeCollection);

        while (--indexFinalCollection >= 0) {
            E maior = null;
            int indexOfListToRemove = -1;

            for (int i = 0; i < collectionOfCollection.size(); i++) {
                final var subListaOrdenada = collectionOfCollection.get(i);
                if (subListaOrdenada.isEmpty()) continue;
                if (Objects.isNull(maior)) maior = subListaOrdenada.getLast();

                final var atualElemento = subListaOrdenada.getLast();
                if (atualElemento.compareTo(maior) < 0) continue;

                maior = atualElemento;
                indexOfListToRemove = i;
            }

            finalCollection[indexFinalCollection] = maior;

            if (indexOfListToRemove == -1) continue;
            final var listToRemove = collectionOfCollection.get(indexOfListToRemove);
            if (listToRemove.isEmpty()) continue;
            final var listToRemoveWithoutLastElement = listToRemove.subList(0, listToRemove.size() - 1);
            collectionOfCollection.set(indexOfListToRemove, listToRemoveWithoutLastElement);
        }

        return List.of( finalCollection);
    }
}
