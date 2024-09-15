package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MochilaDinamicaTest {
    @Test
    public void testMochilaComItensValidos() {
        Item item1 = new Item(3.0, 4.0);
        Item item2 = new Item(4.0, 5.0);
        Item item3 = new Item(2.0, 3.0);

        double capacidadeMochila = 6.0;

        MochilaInfo mochilaInfo = new MochilaInfo(capacidadeMochila, List.of(item1, item2, item3));

        MochilaDinamica mochilaDinamica = new MochilaDinamica();
        List<Item> itensSelecionados = mochilaDinamica.calculaItensParaMochila(mochilaInfo);

        assertFalse(itensSelecionados.contains(item1));
        assertTrue(itensSelecionados.contains(item2));
        assertTrue(itensSelecionados.contains(item3));

        double valorTotal = itensSelecionados.stream().mapToDouble(Item::value).sum();
        assertEquals(8.0, valorTotal);
    }
}
