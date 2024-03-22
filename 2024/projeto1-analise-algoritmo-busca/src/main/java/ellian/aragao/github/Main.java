package ellian.aragao.github;

import ellian.aragao.github.algoritmo.BuscaBinaria;
import ellian.aragao.github.algoritmo.BuscaSequencial;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    private static final BuscaSequencial buscaSequencial = new BuscaSequencial();
    private static final BuscaBinaria buscaBinaria = new BuscaBinaria();

    public static void main(String[] args) {
        final var listStream = inicializaLista();
        executarBusca(listStream, 90_000_000L);
    }

    private static <E extends Comparable<E>> void executarBusca(List<E> lista, E item) {
        final var itemEncontradoOpt = buscaSequencial.buscaSequencial(lista, item);
        itemEncontradoOpt.ifPresentOrElse(itemEncontrado ->
                        System.out.printf("item encontrado %s\n", itemEncontrado),
                () -> System.out.println("Item Não encontrado"));
    }

    private static List<Long> inicializaLista() {
        return LongStream.range(0, 100_000_000L).boxed().collect(Collectors.toList());
    }
}