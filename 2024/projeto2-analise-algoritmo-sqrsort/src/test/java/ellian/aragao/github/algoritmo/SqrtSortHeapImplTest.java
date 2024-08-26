package ellian.aragao.github.algoritmo;

import ellian.aragao.github.utils.GeradorDeNumeros;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SqrtSortHeapImplTest {
    private final SqrtSortHeapImpl sqrtSortHeapImpl = new SqrtSortHeapImpl();
    private final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();

    @Test
    void listaDecrescenteMaiorSqrtSortHeap() {
        List<Long> listDesc = geradorDeNumeros.inicializaListaDecrescente(10);
        final var result = sqrtSortHeapImpl.sqrtSort(listDesc);
        assertEquals(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), result);
    }

}