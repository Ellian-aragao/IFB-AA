package ellian.aragao.github.algoritmo;

public record T3<E1 extends Comparable<E>, E2, E3, E>(
        E1 lastElement,
        E2 listSizeReference,
        E3 indexListOfCollections
) implements Comparable<T3<E1, E2, E3, E>> {

    @Override
    public int compareTo(T3<E1, E2, E3, E> t3) {
        return lastElement.compareTo((E) t3.lastElement());
    }
}
