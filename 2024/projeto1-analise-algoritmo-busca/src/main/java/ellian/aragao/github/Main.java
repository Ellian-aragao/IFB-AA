package ellian.aragao.github;

import ellian.aragao.github.algoritmo.BuscaBinaria;
import ellian.aragao.github.algoritmo.BuscaSequencial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    private static final BuscaSequencial buscaSequencial = new BuscaSequencial();
    private static final BuscaBinaria buscaBinaria = new BuscaBinaria();
    private static final long LIST_SIZE_LONG = 100_000_000L;
    private static final int LIST_SIZE_INT = 100_000_000;

    public static void main(String[] args) {
        final var listStream = inicializaListaOrdenada();
        executarBusca(listStream, 90_000_000L);
    }

    private static <E extends Comparable<E>> void executarBusca(List<E> lista, E item) {
        final var itemEncontradoOpt = buscaSequencial.buscaSequencial(lista, item);
        itemEncontradoOpt.ifPresentOrElse(itemEncontrado ->
                        System.out.printf("item encontrado %s\n", itemEncontrado),
                () -> System.out.println("Item Não encontrado"));
    }

    private static List<Long> inicializaListaOrdenada() {
        return LongStream.range(0, LIST_SIZE_LONG).boxed().collect(Collectors.toList());
    }

    private static List<Long> inicializaListaAleatoria() {
        final var random = new Random();
        final var lista = new ArrayList<Long>(LIST_SIZE_INT);
        for (long i = 0; i < LIST_SIZE_LONG; i++) lista.add(random.nextLong());
        return lista;
    }
}