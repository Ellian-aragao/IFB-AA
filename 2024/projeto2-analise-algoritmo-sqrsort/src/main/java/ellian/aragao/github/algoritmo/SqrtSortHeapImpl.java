package ellian.aragao.github.algoritmo;

import java.util.List;
import java.util.PriorityQueue;

public class SqrtSortHeapImpl extends SqrtSort {
    @Override
    protected <E extends Comparable<E>> List<E> executeSort(List<E> list) {
        final var queue =  new PriorityQueue<E>(list.size());
        queue.addAll(list);
        list.replaceAll(ignored -> queue.poll());
        return list;
    }
}
