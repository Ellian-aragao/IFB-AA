package ellian.aragao.github.algoritmo;

import java.util.Collection;
import java.util.Objects;

public abstract class BaseValidation {

    protected final <E> boolean validation(Collection<E> collection, E itemDeBusca) {
        return Objects.isNull(collection)
                || Objects.isNull(itemDeBusca)
                || collection.isEmpty();
    }
}
