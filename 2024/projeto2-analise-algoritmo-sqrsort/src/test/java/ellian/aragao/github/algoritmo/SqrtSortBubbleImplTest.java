package ellian.aragao.github.algoritmo;

import ellian.aragao.github.utils.GeradorDeNumeros;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SqrtSortBubbleImplTest {
    private final SqrtSortBubbleImpl sqrtSortBubbleImpl = new SqrtSortBubbleImpl();
    private final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();

    @Test
    void listaDecrescenteSqrtSortBubble() {

        List<Long> listDesc = geradorDeNumeros.inicializaListaDecrescente(9);
        final var result = sqrtSortBubbleImpl.executeSort(listDesc);
        assertEquals(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), result);
    }

    @Test
    void listaDecrescenteMaiorSqrtSortBubble() {

        final var result = sqrtSortBubbleImpl.executeSort(geradorDeNumeros.inicializaListaDecrescente(10));
        assertEquals(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), result);
    }

}