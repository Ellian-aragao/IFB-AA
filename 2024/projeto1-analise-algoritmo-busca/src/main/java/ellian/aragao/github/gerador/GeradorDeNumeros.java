package ellian.aragao.github.gerador;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class GeradorDeNumeros {
    private final int listSizeInt;

    public GeradorDeNumeros(int listSize) {
        listSizeInt = listSize;
    }
    public GeradorDeNumeros() {
        listSizeInt = 100_000_000;
    }

    public List<Long> inicializaListaOrdenada() {
        return LongStream.range(0, listSizeInt).boxed().collect(Collectors.toList());
    }

    public List<Long> inicializaListaAleatoria() {
        final var random = new Random();
        final var lista = new ArrayList<Long>(listSizeInt);
        for (int i = 0; i < listSizeInt; i++) lista.add(random.nextLong());
        return lista;
    }

    public List<Long> inicializaListaDescrecente() {
        final var lista = new ArrayList<Long>(listSizeInt);
        for (long i = listSizeInt; i > 0; i--) lista.add(i);
        return lista;
    }
}
