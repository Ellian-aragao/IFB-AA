package ellian.aragao.github.algoritmo.sort;

import ellian.aragao.github.algoritmo.MochilaDinamica;
import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;
import ellian.aragao.github.utils.LeitorDeArquivos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MochilaGulosaPeso2Test {

    @Test
    public void testMochilaComItensValidos() {
        final var item1 = new Item( 4.0, 3.0);
        final var item2 = new Item( 3.0, 2.0);
        final var item3 = new Item( 2.0, 2.0);
        final var item4 = new Item( 1.0, 1.0);

        double capacidade = 5.0;

        final var itens = List.of(item1, item2, item3, item4);

        final var mochilaInfo = new MochilaInfo(capacidade, itens);

        final var mochilaGulosaPeso = new MochilaGulosaPeso2();
        final var itensSelecionados = mochilaGulosaPeso.calculaItensParaMochila(mochilaInfo);

        assertEquals(2, itensSelecionados.size());
        assertEquals(item4, itensSelecionados.get(0));
        assertEquals(item3, itensSelecionados.get(1));
    }

    @Test
    public void testMochilaComItensValidos2() {
        final var path = "data/low-dimensional/f1_l-d_kp_10_269";
        final var leitorArquivos = new LeitorDeArquivos();
        final var mochilaInfo = leitorArquivos.lerItensDoArquivo(path);

        final var mochilaDinamica = new MochilaGulosaPeso2();
        final var itensSelecionados = mochilaDinamica.calculaItensParaMochila(mochilaInfo);

        double valorTotal = itensSelecionados.stream().mapToDouble(Item::value).sum();
        assertEquals(295.0, valorTotal);
    }
}