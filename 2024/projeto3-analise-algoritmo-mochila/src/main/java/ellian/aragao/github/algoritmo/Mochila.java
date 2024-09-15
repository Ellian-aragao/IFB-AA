package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;

import java.util.List;

public interface Mochila {
    List<Item> calculaItensParaMochila(MochilaInfo mochilaInfo);
}
