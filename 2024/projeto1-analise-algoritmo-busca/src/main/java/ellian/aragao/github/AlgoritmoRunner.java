package ellian.aragao.github;

import ellian.aragao.github.algoritmo.BuscaBinaria;
import ellian.aragao.github.algoritmo.BuscaSequencial;
import ellian.aragao.github.algoritmo.BuscaSequencialOtimizada;
import ellian.aragao.github.utils.GeradorDeNumeros;
import ellian.aragao.github.utils.SelecionadorDeNumeros;

import java.util.List;

public class AlgoritmoRunner {

    private static final BuscaSequencial buscaSequencial = new BuscaSequencial();
    private static final BuscaSequencialOtimizada buscaSequencialOtimizada = new BuscaSequencialOtimizada();
    private static final BuscaBinaria buscaBinaria = new BuscaBinaria();
    private static final SelecionadorDeNumeros selecionadorDeNumeros = new SelecionadorDeNumeros(50);
    private static final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();
    private static final List<Integer> tamanhoDasEntradas = List.of(10_000, 100_000, 1_000_000, 10_000_000);

    public static void run() {
        entrada10_000();
        entrada100_000();
        entrada1_000_000();
        entrada10_000_000();
    }

    private static void entrada10_000() {
        AlgoritmoRunner.geraEntradasParaAlgoritmos(10_000);
    }

    private static void entrada100_000() {
        AlgoritmoRunner.geraEntradasParaAlgoritmos(100_000);
    }

    private static void entrada1_000_000() {
        AlgoritmoRunner.geraEntradasParaAlgoritmos(1_000_000);
    }

    private static void entrada10_000_000() {
        AlgoritmoRunner.geraEntradasParaAlgoritmos(10_000_000);
    }

    private static void geraEntradasParaAlgoritmos(Integer tamanhoEntrada) {
        final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(tamanhoEntrada);
        final var listaDescrecente = geradorDeNumeros.inicializaListaDescrecente(tamanhoEntrada);
        final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(tamanhoEntrada);

        executaBuscasNaLista(listaOrdenada);
        executaBuscasNaLista(listaDescrecente);
        executaBuscasNaLista(listaAleatoria);
    }

    private static void executaBuscasNaLista(List<Long> listasDeItens) {
        executarBuscaDeItensIniciais(listasDeItens);
        executarBuscaDeItensMedianos(listasDeItens);
        executarBuscaDeItensFinais(listasDeItens);
    }

    private static void executarBuscaDeItensIniciais(List<Long> listasDeItens) {
        final var itensDeBuscaIniciais = selecionadorDeNumeros.selecionarItensIniciais(listasDeItens);
        itensDeBuscaIniciais.forEach(itemDeBusca -> buscaSequencial.buscaSequencial(listasDeItens, itemDeBusca));
        itensDeBuscaIniciais.forEach(itemDeBusca -> buscaSequencialOtimizada.buscaSequencialOtimizadaComSort(listasDeItens, itemDeBusca));
        itensDeBuscaIniciais.forEach(itemDeBusca -> buscaBinaria.buscaBinariaNaoOrdenada(listasDeItens, itemDeBusca));
    }

    private static void executarBuscaDeItensMedianos(List<Long> listasDeItens) {
        final var itensDeBuscaMedianos = selecionadorDeNumeros.selecionarItensMedianos(listasDeItens);
        itensDeBuscaMedianos.forEach(itemDeBusca -> buscaSequencial.buscaSequencial(listasDeItens, itemDeBusca));
        itensDeBuscaMedianos.forEach(itemDeBusca -> buscaSequencialOtimizada.buscaSequencialOtimizadaComSort(listasDeItens, itemDeBusca));
        itensDeBuscaMedianos.forEach(itemDeBusca -> buscaBinaria.buscaBinariaNaoOrdenada(listasDeItens, itemDeBusca));
    }

    private static void executarBuscaDeItensFinais(List<Long> listasDeItens) {
        final var itensDeBuscaFinais = selecionadorDeNumeros.selecionarItensFinais(listasDeItens);
        itensDeBuscaFinais.forEach(itemDeBusca -> buscaSequencial.buscaSequencial(listasDeItens, itemDeBusca));
        itensDeBuscaFinais.forEach(itemDeBusca -> buscaSequencialOtimizada.buscaSequencialOtimizadaComSort(listasDeItens, itemDeBusca));
        itensDeBuscaFinais.forEach(itemDeBusca -> buscaBinaria.buscaBinariaNaoOrdenada(listasDeItens, itemDeBusca));
    }
}