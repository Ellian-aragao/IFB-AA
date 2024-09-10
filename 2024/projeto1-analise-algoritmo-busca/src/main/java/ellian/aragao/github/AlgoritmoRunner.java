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
    private static final SelecionadorDeNumeros selecionadorDeNumeros = new SelecionadorDeNumeros();
    private static final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();

    public static void run() {
        entrada10_000();
//        entrada100_000();
//        entrada1_000_000();
//        entrada10_000_000();
    }

    private static void entrada10_000() {
        AlgoritmoRunner.geraEntradasParaAlgoritmos(10_000);
    }

//    private static void entrada100_000() {
//        AlgoritmoRunner.geraEntradasParaAlgoritmos(100_000);
//    }
//
//    private static void entrada1_000_000() {
//        AlgoritmoRunner.geraEntradasParaAlgoritmos(1_000_000);
//    }
//
//    private static void entrada10_000_000() {
//        AlgoritmoRunner.geraEntradasParaAlgoritmos(10_000_000);
//    }

    private static void geraEntradasParaAlgoritmos(int tamanhoEntrada) {
        final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(tamanhoEntrada);
        final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(tamanhoEntrada);
        final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(tamanhoEntrada);

        executaBuscasNaLista(listaOrdenada);
        executaBuscasNaLista(listaDescrecente);
        executaBuscasNaLista(listaAleatoria);
    }

    private static void executaBuscasNaLista(List<Long> listasDeItens) {
//        busca10(listasDeItens);
        busca100(listasDeItens);
    }

    private static void busca10(List<Long> listasDeItens) {
        selecionadorDeNumeros.tamanhoDosDadosDeConsulta(10);
        executarBuscaDeItensIniciais(listasDeItens);
        executarBuscaDeItensMedianos(listasDeItens);
        executarBuscaDeItensFinais(listasDeItens);
    }

    private static void busca100(List<Long> listasDeItens) {
        selecionadorDeNumeros.tamanhoDosDadosDeConsulta(100);
        executarBuscaDeItensIniciais(listasDeItens);
        executarBuscaDeItensMedianos(listasDeItens);
        executarBuscaDeItensFinais(listasDeItens);
    }

    private static void executarBuscaDeItensIniciais(List<Long> listasDeItens) {
        final var itensDeBuscaIniciais = selecionadorDeNumeros.selecionarItensIniciais(listasDeItens);
        System.out.println("Buscando itens iniciais");
        executarBuscas(listasDeItens, itensDeBuscaIniciais);
    }

    private static void executarBuscaDeItensMedianos(List<Long> listasDeItens) {
        final var itensDeBuscaMedianos = selecionadorDeNumeros.selecionarItensMedianos(listasDeItens);
        System.out.println("Buscando itens medianos");
        executarBuscas(listasDeItens, itensDeBuscaMedianos);
    }

    private static void executarBuscaDeItensFinais(List<Long> listasDeItens) {
        final var itensDeBuscaFinais = selecionadorDeNumeros.selecionarItensFinais(listasDeItens);
        System.out.println("Buscando itens finais");
        executarBuscas(listasDeItens, itensDeBuscaFinais);
    }

    private static void executarBuscas(List<Long> listasDeItens, List<Long> itensDeBuscaIniciais) {
        var tempoInicial = System.nanoTime();
        buscaSequencial(listasDeItens, itensDeBuscaIniciais);
        var tempoPreSort = System.nanoTime();
        var buscaSequencial = tempoPreSort - tempoInicial;
        final var listaOrdenada = listasDeItens.stream().sorted().toList();
        var tempoPosSort = System.nanoTime();
        var tempoSort = tempoPosSort - tempoPreSort;
        buscaSequencialOtimizada(listaOrdenada, itensDeBuscaIniciais);
        var tempoPosSequencialOtimizada = System.nanoTime();
        var tempoPosOtimizada = tempoPosSequencialOtimizada - tempoPosSort;
        buscaBinaria(listaOrdenada, itensDeBuscaIniciais);
        var tempoPosBinaria = System.nanoTime();
        var tempoBuscaBinaria = tempoPosBinaria - tempoPosSequencialOtimizada;
        System.out.println("busca sequencial: " + buscaSequencial);
        System.out.println("busca sequencial otimizada: " + tempoPosOtimizada);
        System.out.println("busca sequencial binaria: " + tempoBuscaBinaria);
        System.out.println("tempo sort: " + tempoSort);
    }

    private static void buscaBinaria(List<Long> listasDeItens, List<Long> itensDeBusca) {
        for (var itemDeBusca : itensDeBusca) {
            buscaBinaria.buscaBinariaSemSort(listasDeItens, itemDeBusca);
        }
    }

    private static void buscaSequencialOtimizada(List<Long> listasDeItens, List<Long> itensDeBusca) {
        for (var itemDeBusca : itensDeBusca) {
            buscaSequencialOtimizada.buscaSequencialOtimizadaSemSort(listasDeItens, itemDeBusca);
        }
    }

    private static void buscaSequencial(List<Long> listasDeItens, List<Long> itensDeBusca) {
        for (var itemDeBusca : itensDeBusca) {
            buscaSequencial.buscaSequencial(listasDeItens, itemDeBusca);
        }
    }
}