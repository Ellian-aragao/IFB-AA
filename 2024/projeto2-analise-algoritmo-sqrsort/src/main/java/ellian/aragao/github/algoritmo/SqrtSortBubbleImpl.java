package ellian.aragao.github.algoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        final int initialCapacity = intSize + 1;
        final var collectionOfCollection = new ArrayList<List<E>>(initialCapacity);

        for (int i = 0; i < sizeCollection; i += intSize) {
            int fim = Math.min(i + intSize, sizeCollection);
            List<E> subList = collection.subList(i, fim);
            executeSort(subList);
            collectionOfCollection.add(subList);
        }

        final var finalCollection = new ArrayList<E>(sizeCollection);


        final var listOfMaxElements = new ArrayList<T3<E, Integer, Integer, E>>(initialCapacity);

        for (int i = 0; i < collectionOfCollection.size(); i++) {
            final var subListaOrdenada = collectionOfCollection.get(i);
            final var lastElement = subListaOrdenada.getLast();
            final var elementAndSizeSubListAndIndexOfCollection = new T3<>(lastElement, subListaOrdenada.size(), i);
            listOfMaxElements.add(elementAndSizeSubListAndIndexOfCollection);
        }

        executeSort(listOfMaxElements);

        for (int i = listOfMaxElements.size(); 0 < i; i--) {
            final var elementAndSizeSubListAndIndexOfCollection = listOfMaxElements.get(i - 1);


        }

        if (Objects.nonNull(maior)) {
            finalCollection.set(finalCollection.size() - 1, maior);
            removerLista.removeLast();
        }

        collectionOfCollection.removeIf(List::isEmpty);



        return finalCollection;
    }
}
