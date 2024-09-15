package ellian.aragao.github.utils;

import java.util.*;

public class GeradorDeNumeros {
    public List<Long> inicializaListaOrdenada(int quantidadeDeItens) {
        final var lista = new ArrayList<Long>(quantidadeDeItens);
        for (long i = 0; i < quantidadeDeItens; i++) lista.add(i);
        return lista;
    }

    public List<Long> inicializaListaAleatoria(int quantidadeDeItens) {
        final var random = new Random();
        final var lista = new ArrayList<Long>(quantidadeDeItens);
        for (int i = 0; i < quantidadeDeItens; i++) lista.add(random.nextLong());
        return lista;
    }

    public List<Long> inicializaListaDecrescente(int quantidadeDeItens) {
        final var lista = new ArrayList<Long>(quantidadeDeItens);
        for (long i = quantidadeDeItens; i > 0; i--) lista.add(i);
        return lista;
    }
}
