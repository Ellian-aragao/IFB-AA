package ellian.aragao.github.algoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class SqrtSortHeapImpl implements SqrtSort {
    protected <E extends Comparable<E>> List<E> executeSort(List<E> list) {
        final var queue =  new PriorityQueue<E>(list.size());
        queue.addAll(list);
        list.replaceAll(ignored -> queue.poll());
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

        final var queueOfMaxElements =  new PriorityQueue<T3<E, Integer, Integer, E>>(initialCapacity);

        for (int i = 0; i < collectionOfCollection.size(); i++) {
            final var subListaOrdenada = collectionOfCollection.get(i);
            final var lastElement = subListaOrdenada.getLast();
            final var elementAndSizeSubListAndIndexOfCollection = new T3<>(lastElement, subListaOrdenada.size(), i);
            queueOfMaxElements.add(elementAndSizeSubListAndIndexOfCollection);
        }

        final var elementAndSizeSubListAndIndexOfCollection = queueOfMaxElements.poll();




        if (Objects.nonNull(maior)) {
            finalCollection.set(finalCollection.size() - 1, maior);
            removerLista.removeLast();
        }

        collectionOfCollection.removeIf(List::isEmpty);



        return finalCollection;
    }
}
