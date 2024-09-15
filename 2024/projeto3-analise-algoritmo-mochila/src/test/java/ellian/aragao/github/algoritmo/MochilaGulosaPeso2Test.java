package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;
import ellian.aragao.github.algoritmo.sort.MochilaGulosaPeso2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MochilaGulosaPeso2Test {

    @Test
    public void testMochilaComItensValidos() {
        Item item1 = new Item( 4.0, 3.0);
        Item item2 = new Item( 3.0, 2.0);
        Item item3 = new Item( 2.0, 2.0);
        Item item4 = new Item( 1.0, 1.0);

        double capacidade = 5.0;

        List<Item> itens = List.of(item1, item2, item3, item4);

        MochilaInfo mochilaInfo = new MochilaInfo(capacidade, itens);

        MochilaGulosaPeso2 mochilaGulosaPeso = new MochilaGulosaPeso2();
        List<Item> itensSelecionados = mochilaGulosaPeso.calculaItensParaMochila(mochilaInfo);

        assertEquals(2, itensSelecionados.size());
        assertEquals(item3, itensSelecionados.get(0));
        assertEquals(item4, itensSelecionados.get(1));
    }

}