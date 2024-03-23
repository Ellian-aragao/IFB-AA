package ellian.aragao.github.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SelecionadorDeNumeros {
    private final int TAMANHO_DOS_DADOS_DE_CONSULTA = 50;
    public <T> List<T> selecionarItensIniciais(List<T> listaDeItens) {
        int tamanhoTotal = listaDeItens.size();
        int limiteSuperior = tamanhoTotal / 3;
        return selecionarItens(listaDeItens, 0, limiteSuperior);
    }

    public <T> List<T> selecionarItensMedianos(List<T> listaDeItens) {
        int tamanhoTotal = listaDeItens.size();
        int limiteInferior = tamanhoTotal / 3;
        int limiteSuperior = limiteInferior * 2;
        return selecionarItens(listaDeItens, limiteInferior, limiteSuperior);
    }

    public <T> List<T> selecionarItensFinais(List<T> listaDeItens) {
        int tamanhoTotal = listaDeItens.size();
        int limiteInferior = (tamanhoTotal / 3) * 2;
        return selecionarItens(listaDeItens, limiteInferior, tamanhoTotal);
    }

    private <T> List<T> selecionarItens(List<T> listaDeItens, Integer limiteInferior, Integer limiteSuperior) {
        final var random = new Random();
        return IntStream.range(0, TAMANHO_DOS_DADOS_DE_CONSULTA)
                .boxed()
                .map(ignore -> random.nextInt(limiteInferior, limiteSuperior))
                .map(listaDeItens::get)
                .toList();
    }
}
