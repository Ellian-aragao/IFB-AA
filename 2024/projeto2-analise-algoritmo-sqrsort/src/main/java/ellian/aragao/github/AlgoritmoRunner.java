package ellian.aragao.github;

import ellian.aragao.github.utils.GeradorDeNumeros;
import org.apache.commons.lang.NotImplementedException;


public class AlgoritmoRunner {
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

    private static void geraEntradasParaAlgoritmos(int tamanhoEntrada) {
        final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(tamanhoEntrada);
        final var listaDescrecente = geradorDeNumeros.inicializaListaDescrecente(tamanhoEntrada);
        final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(tamanhoEntrada);
        throw new NotImplementedException("Algorithm not implemented yet");
    }
}