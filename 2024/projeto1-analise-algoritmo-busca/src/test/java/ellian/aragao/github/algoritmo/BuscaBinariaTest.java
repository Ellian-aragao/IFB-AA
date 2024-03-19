package ellian.aragao.github.algoritmo;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BuscaBinariaTest {
    private final BuscaBinaria buscaBinaria = new BuscaBinaria();

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaBinaria() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var result = buscaBinaria.buscaBinaria(list, 5);
        assertTrue(result.isPresent());
        assertEquals(5, result.get());
    }

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaBinariaLimiteSuperior() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var result = buscaBinaria.buscaBinaria(list, 9);
        assertTrue(result.isPresent());
        assertEquals(9, result.get());
    }

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaBinariaLimiteInferior() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var result = buscaBinaria.buscaBinaria(list, 0);
        assertTrue(result.isPresent());
        assertEquals(0, result.get());
    }


    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaBinariaMasRetornaVazio() {
        final var list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        final var result = buscaBinaria.buscaBinaria(list, -1);
        assertTrue(result.isEmpty());
    }
}