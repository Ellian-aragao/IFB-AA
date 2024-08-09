package ellian.aragao.github.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SelecionadorDeNumeros {
    private int tamanhoDosDadosDeConsulta = 10;

    public SelecionadorDeNumeros tamanhoDosDadosDeConsulta(int tamanhoDosDadosDeConsulta) {
        this.tamanhoDosDadosDeConsulta = tamanhoDosDadosDeConsulta;
        return this;
    }

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
        return IntStream.range(0, tamanhoDosDadosDeConsulta)
                .boxed()
                .map(ignore -> random.nextInt(limiteInferior, limiteSuperior))
                .map(listaDeItens::get)
                .toList();
    }
}
