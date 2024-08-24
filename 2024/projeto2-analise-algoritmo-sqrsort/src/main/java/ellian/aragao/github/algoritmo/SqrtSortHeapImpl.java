package ellian.aragao.github.algoritmo;

import java.util.*;

public class SqrtSortHeapImpl implements SqrtSort {
    protected <E extends Comparable<E>> PriorityQueue<E> generateHeap(List<E> list) {
        final var queue =  new PriorityQueue<E>(list.size());
        queue.addAll(list);
        return queue;
    }

    public <E extends Comparable<E>> List<E> sqrtSort(List<E> collection) {

        final int sizeCollection = collection.size();
        final int intSize = (int) Math.sqrt(sizeCollection);
        final int initialCapacity = intSize + 1;
        final var collectionOfQueues = new ArrayList<Queue<E>>(initialCapacity);

        for (int i = 0; i < sizeCollection; i += intSize) {
            int fim = Math.min(i + intSize, sizeCollection);
            List<E> subList = collection.subList(i, fim);
            var queue = generateHeap(subList);
            collectionOfQueues.add(queue);
        }

        final var finalCollection = new ArrayList<E>(sizeCollection);
        int indexFinalCollection = sizeCollection;

        final var queueOfMaxElements = generateQueueOfMaxElements(initialCapacity, collectionOfQueues);

        while (--indexFinalCollection >= 0) {
            final var elementAndIndexOfCollection = queueOfMaxElements.poll();
            finalCollection.set(indexFinalCollection, elementAndIndexOfCollection.lastElement());
            final var queue = collectionOfQueues.get(elementAndIndexOfCollection.indexListOfCollections());
            if (queue.isEmpty()) continue;
            final var elementAndIndexOfCollectionReplace = new T2<>(queue.poll(), elementAndIndexOfCollection.indexListOfCollections());
            queueOfMaxElements.add(elementAndIndexOfCollectionReplace);
        }

        return finalCollection;
    }

    private static <E extends Comparable<E>> Queue<T2<E, Integer, E>> generateQueueOfMaxElements(int initialCapacity, List<Queue<E>> collectionOfQueues) {
        final var queueOfMaxElements =  new PriorityQueue<T2<E, Integer, E>>(initialCapacity);

        for (int i = 0; i < collectionOfQueues.size(); i++) {
            final var subListaOrdenada = collectionOfQueues.get(i);
            final var lastElement = subListaOrdenada.poll();
            final var elementAndSizeSubListAndIndexOfCollection = new T2<>(lastElement, i);
            queueOfMaxElements.add(elementAndSizeSubListAndIndexOfCollection);
        }
        return queueOfMaxElements;
    }
}
