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
        final List<E> finalCollection = new ArrayList<>(sizeCollection);
        final List<List<E>> collectionOfCollection = new ArrayList<>();

        for (int i = 0; i < sizeCollection; i += intSize) {
            int fim = Math.min(i + intSize, sizeCollection);
            List<E> subList = collection.subList(i, fim);
            executeSort(subList);
            collectionOfCollection.add(subList);
        }

        int indexFinalCollection = sizeCollection;
        while (--indexFinalCollection >= 0) {
            List<E> removerLista = null;
            E maior = null;

            for (var subListaOrdenada : collectionOfCollection) {
                if (subListaOrdenada.isEmpty()) continue;
                if (Objects.isNull(maior)) maior = subListaOrdenada.getLast();

                final var atualElemento = subListaOrdenada.getLast();
                if (atualElemento.compareTo(maior) >= 0) continue;

                maior = atualElemento;
                removerLista = subListaOrdenada;
            }

            finalCollection.set(indexFinalCollection, maior);
            removerLista.removeLast();
        }

        return finalCollection;
    }
}
