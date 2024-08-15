package ellian.aragao.github.algoritmo;

import java.util.*;

public abstract class SqrSort extends BaseValidation {

    private <E> boolean validation(List<E> collection) {
        return Objects.isNull(collection)
                || collection.isEmpty();
    }

    public <E extends Comparable<E>> List<E> sqrSort(List<E> collection) {
        if (validation(collection)) throw new IllegalArgumentException("List cannot be null or empty");

        final var sizeCollection = collection.size();
        final var sqrtSizeCollection = Math.sqrt(sizeCollection);
        final var intSize = (int) sqrtSizeCollection;
        final var modSize = sizeCollection % intSize;
        final var finalCollection = new ArrayList<E>(sizeCollection);



        return finalCollection;
    }
}
