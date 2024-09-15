package ellian.aragao.github.algoritmo.models;

import java.util.List;

public record MochilaInfo(
        Double capacidadeMochila,
        List<Item> itens
) {
}
