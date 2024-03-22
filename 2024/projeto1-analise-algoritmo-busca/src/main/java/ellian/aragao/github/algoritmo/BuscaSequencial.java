package ellian.aragao.github.algoritmo;

import ellian.aragao.github.models.ResultadoBusca;

import java.util.*;

public class BuscaSequencial extends BaseValidation {
    public <E> Optional<ResultadoBusca<Long, E>> buscaSequencial(Collection<E> collection, E itemDeBusca) {
        if (validation(collection, itemDeBusca)) return Optional.empty();

        long index = 0;
        for (E proximoItem : collection) {
            if (proximoItem.equals(itemDeBusca)) {
                return Optional.of(ResultadoBusca.of(index, proximoItem));
            }
            index++;
        }

        return Optional.empty();
    }
}
