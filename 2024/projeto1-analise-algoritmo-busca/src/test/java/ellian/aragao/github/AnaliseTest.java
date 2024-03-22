package ellian.aragao.github;

import ellian.aragao.github.algoritmo.BuscaBinaria;
import ellian.aragao.github.algoritmo.BuscaSequencial;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnaliseTest {

    private final BuscaSequencial buscaSequencial = new BuscaSequencial();
    private final BuscaBinaria buscaBinaria = new BuscaBinaria();

    @Test
    void testeDeEntradasOrdenada() {
        final var listStream = LongStream.range(0, 10_000_000L).boxed().collect(Collectors.toList());
        final var itemEncontradoOpt = buscaBinaria.buscaBinaria(listStream, 9_000_000L);
        assertTrue(itemEncontradoOpt.isPresent());
    }
}
