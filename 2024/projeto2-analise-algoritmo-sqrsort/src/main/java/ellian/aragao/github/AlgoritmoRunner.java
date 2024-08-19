package ellian.aragao.github;

import ellian.aragao.github.algoritmo.SqrtSortBubbleImpl;
import ellian.aragao.github.algoritmo.SqrtSortHeapImpl;
import ellian.aragao.github.utils.GeradorDeNumeros;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;


public class AlgoritmoRunner {
    private static final SqrtSortHeapImpl sqrtSortHeap = new SqrtSortHeapImpl();
    private static final SqrtSortBubbleImpl sqrtSortBubble = new SqrtSortBubbleImpl();
    private static final GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();
//
//    public static class Entradas10_000 {
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_aleatoriaHeap(Blackhole blackhole) {
//            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(10_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaAleatoria));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_crecenteHeap(Blackhole blackhole) {
//            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(10_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaOrdenada));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_decrecenteHeap(Blackhole blackhole) {
//            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(10_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaDescrecente));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_aleatoriaBubble(Blackhole blackhole) {
//            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(10_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaAleatoria));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_crecenteBubble(Blackhole blackhole) {
//            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(10_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaOrdenada));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_decrecenteBubble(Blackhole blackhole) {
//            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(10_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaDescrecente));
//        }
//    }

//    public static class Entradas100_000 {
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada100_000_aleatoriaHeap(Blackhole blackhole) {
//            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(100_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaAleatoria));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada100_000_crecenteHeap(Blackhole blackhole) {
//            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(100_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaOrdenada)) ;
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada100_000_decrecenteHeap(Blackhole blackhole) {
//            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(100_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaDescrecente));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada100_000_aleatoriaBubble(Blackhole blackhole) {
//            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(100_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaAleatoria));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada100_000_crecenteBubble(Blackhole blackhole) {
//            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(100_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaOrdenada));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada100_000_decrecenteBubble(Blackhole blackhole) {
//            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(100_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaDescrecente));
//        }
//    }

    public static class Entradas1_000_000 {
        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        public static void entrada1_000_000_aleatoriaHeap(Blackhole blackhole) {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(1_000_000);
            blackhole.consume(sqrtSortHeap.sqrtSort(listaAleatoria));
        }

        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        public static void entrada1_000_000_crecenteHeap(Blackhole blackhole) {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(1_000_000);
            blackhole.consume(sqrtSortHeap.sqrtSort(listaOrdenada));
        }

        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        public static void entrada1_000_000_decrecenteHeap(Blackhole blackhole) {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(1_000_000);
            blackhole.consume(sqrtSortHeap.sqrtSort(listaDescrecente));
        }

        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        public static void entrada1_000_000_aleatoriaBubble(Blackhole blackhole) {
            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(1_000_000);
            blackhole.consume(sqrtSortBubble.sqrtSort(listaAleatoria));
        }

        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        public static void entrada1_000_000_crecenteBubble(Blackhole blackhole) {
            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(1_000_000);
            blackhole.consume(sqrtSortBubble.sqrtSort(listaOrdenada));
        }

        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        public static void entrada1_000_000_decrecenteBubble(Blackhole blackhole) {
            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(1_000_000);
            blackhole.consume(sqrtSortBubble.sqrtSort(listaDescrecente));
        }
    }

//    public static class Entradas10_000_000 {
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_000_aleatoriaHeap(Blackhole blackhole) {
//            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(10_000_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaAleatoria));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_000_crecenteHeap(Blackhole blackhole) {
//            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(10_000_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaOrdenada));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_000_decrecenteHeap(Blackhole blackhole) {
//            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(10_000_000);
//            blackhole.consume(sqrtSortHeap.sqrtSort(listaDescrecente));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_000_aleatoriaBubble(Blackhole blackhole) {
//            final var listaAleatoria = geradorDeNumeros.inicializaListaAleatoria(10_000_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaAleatoria));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_000_crecenteBubble(Blackhole blackhole) {
//            final var listaOrdenada = geradorDeNumeros.inicializaListaOrdenada(10_000_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaOrdenada));
//        }
//
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        public static void entrada10_000_000_decrecenteBubble(Blackhole blackhole) {
//            final var listaDescrecente = geradorDeNumeros.inicializaListaDecrescente(10_000_000);
//            blackhole.consume(sqrtSortBubble.sqrtSort(listaDescrecente));
//        }
//    }
}