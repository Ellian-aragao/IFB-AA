package ellian.aragao.github.utils;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class GeradorDeNumeros {
    public List<Long> inicializaListaOrdenada(int quantidadeDeItens) {
        return LongStream.range(0, quantidadeDeItens).boxed().collect(Collectors.toList());
    }

    public List<Long> inicializaListaAleatoria(int quantidadeDeItens) {
        final var random = new Random();
        final var lista = new ArrayList<Long>(quantidadeDeItens);
        for (int i = 0; i < quantidadeDeItens; i++) lista.add(random.nextLong());
        return lista;
    }

    public List<Long> inicializaListaDescrecente(int quantidadeDeItens) {
        final var lista = new ArrayList<Long>(quantidadeDeItens);
        for (long i = quantidadeDeItens; i > 0; i--) lista.add(i);
        return lista;
    }
}
