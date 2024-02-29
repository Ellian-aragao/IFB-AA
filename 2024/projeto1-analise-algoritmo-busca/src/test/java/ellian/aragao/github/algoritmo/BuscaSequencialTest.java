package ellian.aragao.github.algoritmo;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BuscaSequencialTest {

    private final BuscaSequencial buscaSequencial = new BuscaSequencial();

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencial() {
        final var list = IntStream.range(0, 10).boxed().toList();
        final var result = buscaSequencial.buscaSequencial(list, 5);
        assertTrue(result.isPresent());
        assertEquals(5, result.get());
    }

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencialMasRetornaVazio() {
        final var list = IntStream.range(0, 10).boxed().toList();
        final var result = buscaSequencial.buscaSequencial(list, -1);
        assertTrue(result.isEmpty());
    }

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencialOtimizada() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var result = buscaSequencial.buscaSequencialOtimizada(list, 5);
        assertTrue(result.isPresent());
        assertEquals(5, result.get());
    }

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencialOtimizadaMasRetornaVazioUtilizandoLimites() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var result = buscaSequencial.buscaSequencialOtimizada(list, -1);
        assertTrue(result.isEmpty());
        final var result1 = buscaSequencial.buscaSequencialOtimizada(list, 10);
        assertTrue(result1.isEmpty());
    }


    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencialOtimizadaMasRetornaVazioFaltandoNumeroEntre() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var itemABuscar = list.remove(4);
        final var result = buscaSequencial.buscaSequencialOtimizada(list, itemABuscar);
        assertTrue(result.isEmpty());
    }
}