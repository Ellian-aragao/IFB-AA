package ellian.aragao.github;

import ellian.aragao.github.algoritmo.SqrtSortBubbleImpl;
import ellian.aragao.github.algoritmo.SqrtSortHeapImpl;
import ellian.aragao.github.utils.GeradorDeNumeros;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;


public class AlgoritmoRunner {
    private static final SqrtSortHeapImpl sqrtSortHeap = new SqrtSortHeapImpl();
    private static final SqrtSortBubbleImpl sqrtSortBubble = new SqrtSortBubbleImpl();
    private static final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();

    public static class Entradas10_000 {
        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_aleatoriaHeap() {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(10_000);
            sqrtSortHeap.sqrtSort(listaAleatoria);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_crecenteHeap() {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(10_000);
            sqrtSortHeap.sqrtSort(listaOrdenada);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_decrecenteHeap() {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(10_000);
            sqrtSortHeap.sqrtSort(listaDescrecente);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_aleatoriaBubble() {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(10_000);
            sqrtSortBubble.sqrtSort(listaAleatoria);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_crecenteBubble() {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(10_000);
            sqrtSortBubble.sqrtSort(listaOrdenada);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_decrecenteBubble() {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(10_000);
            sqrtSortBubble.sqrtSort(listaDescrecente);
        }
    }

    public static class Entradas100_000 {
        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada100_000_aleatoriaHeap() {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(100_000);
            sqrtSortHeap.sqrtSort(listaAleatoria);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada100_000_crecenteHeap() {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(100_000);
            sqrtSortHeap.sqrtSort(listaOrdenada);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada100_000_decrecenteHeap() {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(100_000);
            sqrtSortHeap.sqrtSort(listaDescrecente);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada100_000_aleatoriaBubble() {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(100_000);
            sqrtSortBubble.sqrtSort(listaAleatoria);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada100_000_crecenteBubble() {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(100_000);
            sqrtSortBubble.sqrtSort(listaOrdenada);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada100_000_decrecenteBubble() {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(100_000);
            sqrtSortBubble.sqrtSort(listaDescrecente);
        }
    }

    public static class Entradas1_000_000 {
        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada1_000_000_aleatoriaHeap() {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(1_000_000);
            sqrtSortHeap.sqrtSort(listaAleatoria);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada1_000_000_crecenteHeap() {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(1_000_000);
            sqrtSortHeap.sqrtSort(listaOrdenada);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada1_000_000_decrecenteHeap() {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(1_000_000);
            sqrtSortHeap.sqrtSort(listaDescrecente);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada1_000_000_aleatoriaBubble() {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(1_000_000);
            sqrtSortBubble.sqrtSort(listaAleatoria);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada1_000_000_crecenteBubble() {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(1_000_000);
            sqrtSortBubble.sqrtSort(listaOrdenada);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada1_000_000_decrecenteBubble() {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(1_000_000);
            sqrtSortBubble.sqrtSort(listaDescrecente);
        }
    }

    public static class Entradas10_000_000 {
        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_000_aleatoriaHeap() {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(10_000_000);
            sqrtSortHeap.sqrtSort(listaAleatoria);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_000_crecenteHeap() {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(10_000_000);
            sqrtSortHeap.sqrtSort(listaOrdenada);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_000_decrecenteHeap() {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(10_000_000);
            sqrtSortHeap.sqrtSort(listaDescrecente);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_000_aleatoriaBubble() {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(10_000_000);
            sqrtSortBubble.sqrtSort(listaAleatoria);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_000_crecenteBubble() {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(10_000_000);
            sqrtSortBubble.sqrtSort(listaOrdenada);
        }

        @Benchmark
        @BenchmarkMode(Mode.All)
        public static void entrada10_000_000_decrecenteBubble() {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(10_000_000);
            sqrtSortBubble.sqrtSort(listaDescrecente);
        }
    }
}