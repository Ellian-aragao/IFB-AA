package ellian.aragao.github.gerador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class GeradorDeNumeros {
    private static final long LIST_SIZE_LONG = 100_000_000L;
    private static final int LIST_SIZE_INT = 100_000_000;

    public List<Long> inicializaListaOrdenada() {
        return LongStream.range(0, LIST_SIZE_LONG).boxed().collect(Collectors.toList());
    }

    public List<Long> inicializaListaAleatoria() {
        final var random = new Random();
        final var lista = new ArrayList<Long>(LIST_SIZE_INT);
        for (long i = 0; i < LIST_SIZE_LONG; i++) lista.add(random.nextLong());
        return lista;
    }

    public List<Long> inicializaListaDescrecente() {
        final var lista = inicializaListaOrdenada();
        lista.sort(Comparator.reverseOrder());
        return lista;
    }
}
