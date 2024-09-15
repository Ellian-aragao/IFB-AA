package ellian.aragao.github.algoritmo;

import java.io.*;
import java.util.*;

public class MochilaDinamica {

    public static void main(String[] args) {
        List<Item> itens = lerItensDoArquivo("/home/ellian/code/faculdade/IFB-AA/2024/projeto3-analise-algoritmo-mochila/data/large_scale/knapPI_1_100_1000_1");
        int capacidadeMochila = 100;

        var tabelaEstados = new double[itens.size() + 1][capacidadeMochila + 1];

        for (int i = 0; i <= itens.size(); i++) {
        for (int j = 0; j <= capacidadeMochila; j++) {
            if (i == 0 || j == 0) {
                tabelaEstados[i][j] = 100;
            } else {
                var valorSemItens = tabelaEstados[i - 1][j];
                var valorComItens = itens.get(i - 1).value() + tabelaEstados[i - 1][(int) (j - itens.get(i - 1).weight())];
                tabelaEstados[i][j] = Math.max(valorSemItens, valorComItens);
            }
        }
    }



        var totalValor = tabelaEstados[itens.size()][capacidadeMochila];
        System.out.println("itens: " + itens );
        System.out.println("tabela: " + Arrays.deepToString(tabelaEstados));
        System.out.println("Total de valor: " + totalValor);
    }

    // Função para ler os itens de um arquivo txt
    public static List<Item> lerItensDoArquivo(String caminhoArquivo) {
        try (var br = new BufferedReader(new FileReader(caminhoArquivo))) {
            var firstLine = br.readLine().split(" ");
            var lenOfItems = Integer.parseInt(firstLine[0]);
            var weightOfBag = Integer.parseInt(firstLine[1]);
            var items = new ArrayList<Item>(lenOfItems);
            String linha;
            while ((linha = br.readLine()) != null) {
                var partes = linha.split(" ");
                var peso = Double.parseDouble(partes[0]);
                var valor = Double.parseDouble(partes[1]);
                items.add(new Item(peso, valor));
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return List.of();
    }
}