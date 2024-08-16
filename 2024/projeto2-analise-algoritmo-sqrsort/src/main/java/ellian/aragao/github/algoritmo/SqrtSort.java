package ellian.aragao.github.algoritmo;

import java.util.*;

public abstract class SqrtSort {

    private <E> boolean validation(List<E> collection) {
        return Objects.isNull(collection)
                || collection.isEmpty();
    }

    public <E extends Comparable<E>> List<E> sqrtSort(List<E> collection) {
        if (validation(collection)) throw new IllegalArgumentException("List cannot be null or empty");

        final var sizeCollection = collection.size();
        final var sqrtSizeCollection = Math.sqrt(sizeCollection);
        final var intSize = (int) sqrtSizeCollection;
        final var modSize = sizeCollection % intSize;
        final var finalCollection = new ArrayList<E>(sizeCollection);
        final var collectionOfCollection = new ArrayList<List <E>>( intSize + 1);
        for (int i = 0; i <  intSize; i++) {
            final var prefixIndex = i * intSize;
            final var subListaOrdenada = executeSort(collection.subList(prefixIndex, prefixIndex + intSize));
            collectionOfCollection.add(subListaOrdenada);
        }
        if (modSize > 0) {
            collectionOfCollection.add(collection.subList(intSize * (intSize - 1) , sizeCollection - 1));
        }

        while (!collectionOfCollection.isEmpty() ){
            for (var subListaOrdenada: collectionOfCollection) {
                if (subListaOrdenada.isEmpty()){
                    collectionOfCollection.remove(subListaOrdenada);
                    break;
                }

                final var maior = subListaOrdenada.removeLast();
                final var maiorComparacao = maior.compareTo(finalCollection.getLast());

                if (maiorComparacao > 0) {
                    finalCollection.add(maior);
                }
            }
        }

        return finalCollection;
    }

    protected abstract <E extends Comparable<E>> List<E> executeSort(List<E> es);
}
