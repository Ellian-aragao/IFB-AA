package ellian.aragao.github;

import ellian.aragao.github.algoritmo.BuscaBinaria;
import ellian.aragao.github.algoritmo.BuscaSequencial;
import ellian.aragao.github.algoritmo.BuscaSequencialOtimizada;
import ellian.aragao.github.utils.GeradorDeNumeros;
import ellian.aragao.github.utils.SelecionadorDeNumeros;

import java.util.List;
import java.util.function.Consumer;

public class AlgoritmoRunner {
    private static final BuscaSequencial buscaSequencial = new BuscaSequencial();
    private static final BuscaSequencialOtimizada buscaSequencialOtimizada = new BuscaSequencialOtimizada();
    private static final BuscaBinaria buscaBinaria = new BuscaBinaria();
    private static final SelecionadorDeNumeros selecionadorDeNumeros = new SelecionadorDeNumeros(50);
    private static final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();

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
        executarBuscas(listasDeItens, itensDeBuscaIniciais);
    }

    private static void executarBuscaDeItensMedianos(List<Long> listasDeItens) {
        final var itensDeBuscaMedianos = selecionadorDeNumeros.selecionarItensMedianos(listasDeItens);
        executarBuscas(listasDeItens, itensDeBuscaMedianos);
    }

    private static void executarBuscaDeItensFinais(List<Long> listasDeItens) {
        final var itensDeBuscaFinais = selecionadorDeNumeros.selecionarItensFinais(listasDeItens);
        executarBuscas(listasDeItens, itensDeBuscaFinais);
    }

    private static void executarBuscas(List<Long> listasDeItens, List<Long> itensDeBuscaIniciais) {
        buscaSequencial(listasDeItens, itensDeBuscaIniciais);
        buscaSequencialOtimizada(listasDeItens, itensDeBuscaIniciais);
        buscaBinaria(listasDeItens, itensDeBuscaIniciais);
    }

    private static void buscaBinaria(List<Long> listasDeItens, List<Long> itensDeBusca) {
        for (var itemDeBusca: itensDeBusca){
            buscaBinaria.buscaBinariaComSort(listasDeItens, itemDeBusca);
        }
    }

    private static void buscaSequencialOtimizada(List<Long> listasDeItens, List<Long> itensDeBusca) {
        for (var itemDeBusca: itensDeBusca){
            buscaSequencialOtimizada.buscaSequencialOtimizadaComSort(listasDeItens, itemDeBusca);
        }
    }

    private static void buscaSequencial(List<Long> listasDeItens, List<Long> itensDeBusca) {
        for (var itemDeBusca: itensDeBusca){
            buscaSequencial.buscaSequencial(listasDeItens, itemDeBusca);
        }
    }
}