package ellian.aragao.github.algoritmo;

public record T2<E1 extends Comparable<E>, E2, E>(
        E1 lastElement,
        E2 indexListOfCollections
) implements Comparable<T2<E1, E2, E>> {

    @Override
    public int compareTo(T2<E1, E2, E> t2) {
        return lastElement.compareTo((E) t2.lastElement());
    }
}
