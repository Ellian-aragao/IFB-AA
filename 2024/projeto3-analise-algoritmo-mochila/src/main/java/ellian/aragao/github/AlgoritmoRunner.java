package ellian.aragao.github;

import ellian.aragao.github.algoritmo.MochilaDinamica;
import ellian.aragao.github.algoritmo.sort.MochilaGulosaPeso2;
import ellian.aragao.github.algoritmo.sort.MochilaGulosaValorCusto2;
import ellian.aragao.github.utils.LeitorDeArquivos;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


public class AlgoritmoRunner {
    private static final LeitorDeArquivos leitorDeArquivos = new LeitorDeArquivos();
    private static final MochilaDinamica mochilaDinamica = new MochilaDinamica();
    private static final MochilaGulosaPeso2 mochilaPeso = new MochilaGulosaPeso2();
    private static final MochilaGulosaValorCusto2 mochilaValorPorPeso = new MochilaGulosaValorCusto2();

    public static class Entrada_100 {
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_100_leitura(Blackhole blackhole) {
//            blackhole.consume(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_100_1000_1"));
//        }

        @Benchmark
        @Fork(value = 3)
        @Threads(Threads.MAX)
        @BenchmarkMode(Mode.AverageTime)
        @OutputTimeUnit(TimeUnit.MILLISECONDS)
        public static void entrada_100_mochilaDinamica(Blackhole blackhole) {
            final var itensSelecionados = mochilaDinamica.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_100_1000_1"));
            blackhole.consume(itensSelecionados);
        }


//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_100_mochilaPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_100_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_100_mochilaValorPorPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaValorPorPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_100_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
    }

    public static class Entrada_200 {

        @Benchmark
       @Fork(value = 3)
       @Threads(Threads.MAX)
       @BenchmarkMode(Mode.AverageTime)
       @OutputTimeUnit(TimeUnit.MILLISECONDS)
       public static void entrada_200_leitura(Blackhole blackhole) {
           blackhole.consume(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_200_1000_1"));
       }
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_200_mochilaDinamica(Blackhole blackhole) {
//            final var itensSelecionados = mochilaDinamica.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_200_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_200_mochilaPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_200_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_200_mochilaValorPorPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaValorPorPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_200_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
    }

//    public static class Entrada_500 {
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_500_leitura(Blackhole blackhole) {
//            blackhole.consume(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_500_1000_1"));
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_500_mochilaDinamica(Blackhole blackhole) {
//            final var itensSelecionados = mochilaDinamica.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_500_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_500_mochilaPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_500_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_500_mochilaValorPorPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaValorPorPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_500_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//    }

//    public static class Entrada_1000 {
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_1000_leitura(Blackhole blackhole) {
//            blackhole.consume(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_1000_1000_1"));
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_1000_mochilaDinamica(Blackhole blackhole) {
//            final var itensSelecionados = mochilaDinamica.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_1000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_1000_mochilaPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_1000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_1000_mochilaValorPorPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaValorPorPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_1000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//    }

//    public static class Entrada_2000 {
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_2000_leitura(Blackhole blackhole) {
//            blackhole.consume(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_2000_1000_1"));
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_2000_mochilaDinamica(Blackhole blackhole) {
//            final var itensSelecionados = mochilaDinamica.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_2000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_2000_mochilaPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_2000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_2000_mochilaValorPorPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaValorPorPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_2000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//    }

//    public static class Entrada_5000 {
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_5000_leitura(Blackhole blackhole) {
//            blackhole.consume(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_5000_1000_1"));
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_5000_mochilaDinamica(Blackhole blackhole) {
//            final var itensSelecionados = mochilaDinamica.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_5000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_5000_mochilaPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_5000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_5000_mochilaValorPorPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaValorPorPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_5000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//    }

    public static class Entrada_10000 {
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_10000_leitura(Blackhole blackhole) {
//            blackhole.consume(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_10000_1000_1"));
//        }

        @Benchmark
        @Fork(value = 3)
        @Threads(Threads.MAX)
        @BenchmarkMode(Mode.AverageTime)
        @OutputTimeUnit(TimeUnit.MILLISECONDS)
        public static void entrada_10000_mochilaDinamica(Blackhole blackhole) {
            final var itensSelecionados = mochilaDinamica.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_10000_1000_1"));
            blackhole.consume(itensSelecionados);
        }

//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_10000_mochilaPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_10000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
//
//        @Benchmark
//        @Fork(value = 3)
//        @Threads(Threads.MAX)
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.MILLISECONDS)
//        public static void entrada_10000_mochilaValorPorPeso(Blackhole blackhole) {
//            final var itensSelecionados = mochilaValorPorPeso.calculaItensParaMochila(leitorDeArquivos.lerItensDoArquivo("data/large_scale/knapPI_1_10000_1000_1"));
//            blackhole.consume(itensSelecionados);
//        }
    }
}