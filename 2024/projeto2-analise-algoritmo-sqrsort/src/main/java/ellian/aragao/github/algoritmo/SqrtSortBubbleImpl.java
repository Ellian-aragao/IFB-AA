package ellian.aragao.github.algoritmo;

import java.util.List;

public class SqrtSortBubbleImpl extends SqrtSort {
    @Override
    protected <E extends Comparable<E>> List<E> executeSort(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                final var compare = list.get(i).compareTo(list.get(j));
                if (compare > 0) {
                    final var tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        return list;
    }
}
