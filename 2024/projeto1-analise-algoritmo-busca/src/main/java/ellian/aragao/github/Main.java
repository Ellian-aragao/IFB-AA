package ellian.aragao.github;

import ellian.aragao.github.algoritmo.BuscaBinaria;
import ellian.aragao.github.algoritmo.BuscaSequencial;
import ellian.aragao.github.algoritmo.BuscaSequencialOtimizada;
import ellian.aragao.github.utils.GeradorDeNumeros;
import ellian.aragao.github.utils.SelecionadorDeNumeros;

import java.util.List;

public class Main {
    private static final BuscaSequencial buscaSequencial = new BuscaSequencial();
    private static final BuscaSequencialOtimizada buscaSequencialOtimizada = new BuscaSequencialOtimizada();
    private static final BuscaBinaria buscaBinaria = new BuscaBinaria();
    private static final SelecionadorDeNumeros selecionadorDeNumeros = new SelecionadorDeNumeros();
    private static final int listSize = 10_000;
    private static final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros(listSize);


    public static void main(String[] args) {
        final var listStream = geradorDeNumeros.inicializaListaOrdenada();
//        final var listStream = geradorDeNumeros.inicializaListaAleatoria();
//        final var listStream = geradorDeNumeros.inicializaListaDescrecente();

        final var a = selecionadorDeNumeros.selecionarItensFinais(listStream);
        final var b = selecionadorDeNumeros.selecionarItensMedianos(listStream);
        selecionadorDeNumeros.selecionarItensIniciais(listStream)
                .forEach(itemBusca -> executarBusca(listStream, itemBusca));
    }

    private static <E extends Comparable<E>> void executarBusca(List<E> lista, E itemDeBusca) {
        buscaSequencial.buscaSequencial(lista, itemDeBusca).ifPresentOrElse(
                itemEncontrado -> System.out.printf("Item encontrado: %s%s", itemEncontrado, System.lineSeparator()),
                () -> System.out.println("Item Não encontrado"));
    }
}