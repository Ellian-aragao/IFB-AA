import java.io.*;
import java.util.*;

class Item {
    private int peso;
    private int valor;

    public Item(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }
}

public class MochilaDinamica {

    public static void main(String[] args) {
        List<Item> itens = lerItensDoArquivo("/data/knapPI_1_100_1000_1");
        int capacidadeMochila = 10;

        int[][] tabelaEstados = new int[itens.size() + 1][capacidadeMochila + 1];

        for (int i = 0; i <= itens.size(); i++) {
            for (int j = 0; j <= capacidadeMochila; j++) {
                if (i == 0) {
                    tabelaEstados[i][j] = 0;
                } else if (itens.get(i - 1).getPeso() > j) {
                    tabelaEstados[i][j] = tabelaEstados[i - 1][j];
                } else {
                    int valorSemItens = tabelaEstados[i - 1][j];
                    int valorComItens = itens.get(i - 1).getValor() + tabelaEstados[i - 1][j - itens.get(i - 1).getPeso()];
                    tabelaEstados[i][j] = Math.max(valorSemItens, valorComItens);
                }
            }
        }

        int totalValor = tabelaEstados[itens.size()][capacidadeMochila];
        System.out.println("Total de valor: " + totalValor);
    }

    // Função para ler os itens de um arquivo txt
    public static List<Item> lerItensDoArquivo(String caminhoArquivo) {
        List<Item> itens = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" ");
                int peso = Integer.parseInt(partes[0]);
                int valor = Integer.parseInt(partes[1]);
                itens.add(new Item(peso, valor));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itens;
    }
}