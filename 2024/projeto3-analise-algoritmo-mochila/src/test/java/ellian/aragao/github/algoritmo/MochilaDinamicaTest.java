package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;
import ellian.aragao.github.utils.LeitorDeArquivos;
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

    @Test
    public void testMochilaComItensSimples() {
        Item item1 = new Item(2.0, 3.0);
        Item item2 = new Item(3.0, 4.0);
        Item item3 = new Item(4.0, 5.0);

        double capacidade = 5.0;

        List<Item> itens = List.of(item1, item2, item3);

        MochilaInfo mochilaInfo = new MochilaInfo(capacidade, itens);

        MochilaDinamica mochilaDinamica = new MochilaDinamica();
        List<Item> itensSelecionados = mochilaDinamica.calculaItensParaMochila(mochilaInfo);

        assertEquals(2, itensSelecionados.size());
        assertTrue(itensSelecionados.contains(item1));
        assertTrue(itensSelecionados.contains(item2));
    }

    @Test
    public void testMochilaComCapacidadeExata() {
        Item item1 = new Item(2.0, 3.0);
        Item item2 = new Item(3.0, 4.0);
        Item item3 = new Item(5.0, 8.0);

        double capacidade = 5.0;

        List<Item> itens = List.of(item1, item2, item3);

        MochilaInfo mochilaInfo = new MochilaInfo(capacidade, itens);

        MochilaDinamica mochilaDinamica = new MochilaDinamica();
        List<Item> itensSelecionados = mochilaDinamica.calculaItensParaMochila(mochilaInfo);

        assertEquals(1, itensSelecionados.size());
        assertTrue(itensSelecionados.contains(item3));
    }
    @Test
    public void testMochilaComCapacidadeInsuficiente() {
        Item item1 = new Item(10.0, 20.0);
        Item item2 = new Item(15.0, 30.0);

        double capacidade = 5.0;

        List<Item> itens = List.of(item1, item2);

        MochilaInfo mochilaInfo = new MochilaInfo(capacidade, itens);

        MochilaDinamica mochilaDinamica = new MochilaDinamica();
        List<Item> itensSelecionados = mochilaDinamica.calculaItensParaMochila(mochilaInfo);

        assertTrue(itensSelecionados.isEmpty());
    }
    @Test
    public void testMochilaComPesoEValoresIguais() {
        Item item1 = new Item(2.0, 2.0);
        Item item2 = new Item(3.0, 3.0);
        Item item3 = new Item(4.0, 4.0);

        double capacidade = 5.0;

        List<Item> itens = List.of(item1, item2, item3);

        MochilaInfo mochilaInfo = new MochilaInfo(capacidade, itens);

        MochilaDinamica mochilaDinamica = new MochilaDinamica();
        List<Item> itensSelecionados = mochilaDinamica.calculaItensParaMochila(mochilaInfo);

        assertEquals(2, itensSelecionados.size());
        assertTrue(itensSelecionados.contains(item1));
        assertTrue(itensSelecionados.contains(item2));
    }



    @Test
    public void testMochilaComItensValidos2() {
        final var path = "data/low-dimensional/f1_l-d_kp_10_269";
        final var leitorArquivos = new LeitorDeArquivos();
        MochilaInfo mochilaInfo = leitorArquivos.lerItensDoArquivo(path);

        MochilaDinamica mochilaDinamica = new MochilaDinamica();
        List<Item> itensSelecionados = mochilaDinamica.calculaItensParaMochila(mochilaInfo);

        double valorTotal = itensSelecionados.stream().mapToDouble(Item::value).sum();
        assertEquals(295.0, valorTotal);
    }
}
