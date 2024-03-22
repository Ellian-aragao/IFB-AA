package ellian.aragao.github.algoritmo;

import ellian.aragao.github.models.ResultadoBusca;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BuscaSequencialOtimizadaTest {

    private final BuscaSequencialOtimizada buscaSequencial = new BuscaSequencialOtimizada();


    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencialOtimizada() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var result = buscaSequencial.buscaSequencialOtimizadaComSort(list, 5);
        assertTrue(result.isPresent());
        assertEquals(5, result.map(ResultadoBusca::item).orElseThrow());
    }

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencialOtimizadaMasRetornaVazioUtilizandoLimites() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var result = buscaSequencial.buscaSequencialOtimizadaComSort(list, -1);
        assertTrue(result.isEmpty());
        final var result1 = buscaSequencial.buscaSequencialOtimizadaComSort(list, 10);
        assertTrue(result1.isEmpty());
    }


    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencialOtimizadaMasRetornaVazioFaltandoNumeroEntre() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var itemABuscar = list.remove(4);
        final var result = buscaSequencial.buscaSequencialOtimizadaComSort(list, itemABuscar);
        assertTrue(result.isEmpty());
    }

}