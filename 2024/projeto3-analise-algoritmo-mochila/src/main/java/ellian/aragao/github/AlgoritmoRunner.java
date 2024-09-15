package ellian.aragao.github;

import ellian.aragao.github.utils.LeitorDeArquivos;
import org.apache.commons.lang.NotImplementedException;


public class AlgoritmoRunner {
    private static final LeitorDeArquivos LEITOR_DE_ARQUIVOS = new LeitorDeArquivos();

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
        throw new NotImplementedException("Algorithm not implemented yet");
    }
}