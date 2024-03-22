package ellian.aragao.github;

import ellian.aragao.github.algoritmo.BuscaBinaria;
import ellian.aragao.github.algoritmo.BuscaSequencial;
import ellian.aragao.github.algoritmo.BuscaSequencialOtimizada;
import ellian.aragao.github.gerador.GeradorDeNumeros;

import java.util.List;

public class Main {
    private static final BuscaSequencial buscaSequencial = new BuscaSequencial();
    private static final BuscaSequencialOtimizada buscaSequencialOtimizada = new BuscaSequencialOtimizada();
    private static final BuscaBinaria buscaBinaria = new BuscaBinaria();
    private static final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();


    public static void main(String[] args) {
        final var listStream = geradorDeNumeros.inicializaListaOrdenada();
        executarBusca(listStream, 90_000_000L);
    }

    private static <E extends Comparable<E>> void executarBusca(List<E> lista, E item) {
        final var itemEncontradoOpt = buscaSequencial.buscaSequencial(lista, item);
        itemEncontradoOpt.ifPresentOrElse(itemEncontrado ->
                        System.out.printf("Item encontrado: %s%s", itemEncontrado, System.lineSeparator()),
                () -> System.out.println("Item Não encontrado"));
    }
}