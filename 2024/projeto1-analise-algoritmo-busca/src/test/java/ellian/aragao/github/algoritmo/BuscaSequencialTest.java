package ellian.aragao.github.algoritmo;

import ellian.aragao.github.models.ResultadoBusca;
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
        assertEquals(5, result.map(ResultadoBusca::item).orElseThrow());
    }

    @Test
    void verificaSeEncontraNumeroUtilizandoBuscaSequencialMasRetornaVazio() {
        final var list = IntStream.range(0, 10).boxed().toList();
        final var result = buscaSequencial.buscaSequencial(list, -1);
        assertTrue(result.isEmpty());
    }
}