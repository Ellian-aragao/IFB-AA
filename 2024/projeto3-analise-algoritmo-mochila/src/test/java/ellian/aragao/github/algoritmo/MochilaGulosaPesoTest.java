package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MochilaGulosaPesoTest {
    @Test
    public void testMochilaComItensValidos() {
        Item item1 = new Item(4.0, 3.0);
        Item item2 = new Item(3.0, 2.0);
        Item item3 = new Item(2.0, 2.0);
        Item item4 = new Item(1.0, 1.0);

        double capacidade = 5.0;

        List<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);

        MochilaInfo mochilaInfo = new MochilaInfo(capacidade, itens);

        MochilaGulosaPeso mochilaGulosaPeso = new MochilaGulosaPeso();
        List<Item> itensSelecionados = mochilaGulosaPeso.calculaItensParaMochila(mochilaInfo);

        assertEquals(2, itensSelecionados.size());
        assertEquals(item3, itensSelecionados.get(0));
        assertEquals(item4, itensSelecionados.get(1));
    }
}