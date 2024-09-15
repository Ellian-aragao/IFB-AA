package ellian.aragao.github.algoritmo;

import ellian.aragao.github.algoritmo.models.Item;

import java.io.*;
import java.util.*;

public class MochilaDinamica {

    public static void main(String[] args) {
        List<Item> itens = lerItensDoArquivo("C:\\Users\\João Vítor\\Desktop\\projeto\\IFB-AA\\2024\\projeto3-analise-algoritmo-mochila\\data\\large_scale\\knapPI_1_200_1000_1");
        int capacidadeMochila = 200;

        var tabelaEstados = new double[itens.size() + 1][capacidadeMochila + 1];

        for (int i = 0; i <= itens.size(); i++) {
            for (int j = 0; j <= capacidadeMochila; j++) {
                if (i == 0 || j == 0) {
                    tabelaEstados[i][j] = 0;
                } else {
                    var valorSemItens = tabelaEstados[i - 1][j];
                    var pesoItemAtual = itens.get(i - 1).weight();
                    if (pesoItemAtual <= j) {
                        var valorComItens = itens.get(i - 1).value() + tabelaEstados[i - 1][(int) (j - pesoItemAtual)];
                        tabelaEstados[i][j] = Math.max(valorSemItens, valorComItens);
                    } else {
                        tabelaEstados[i][j] = valorSemItens;
                    }
                }
            }
        }



        var totalValor = tabelaEstados[itens.size()][capacidadeMochila];
        System.out.println("itens: " + itens );
        System.out.println("Total de valor: " + totalValor);
    }

    // Função para ler os itens de um arquivo txt
    public static List<Item> lerItensDoArquivo(String caminhoArquivo) {
        var items = new ArrayList<Item>();
        try (var br = new BufferedReader(new FileReader(caminhoArquivo))) {
            var firstLine = br.readLine().split(" ");
            var lenOfItems = Integer.parseInt(firstLine[0]);
            var weightOfBag = Integer.parseInt(firstLine[1]);

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
        return items;  // Retorna a lista de itens lidos corretamente
    }
}