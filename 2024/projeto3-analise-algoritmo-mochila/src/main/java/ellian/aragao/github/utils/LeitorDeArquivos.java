package ellian.aragao.github.utils;

import ellian.aragao.github.algoritmo.models.Item;
import ellian.aragao.github.algoritmo.models.MochilaInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeitorDeArquivos {
    public MochilaInfo lerItensDoArquivo(String caminhoArquivo) {
        try (var br = new BufferedReader(new FileReader(caminhoArquivo))) {
            final var firstLine = br.readLine().split(" ");
            final var lenOfItems = Integer.parseInt(firstLine[0]);
            final var weightOfBag = Double.parseDouble(firstLine[1]);
            final var items = new ArrayList<Item>(lenOfItems);

            String linha;
            while ((linha = br.readLine()) != null) {
                var partes = linha.split(" ");
                if (partes.length != 2) break;
                var value = Double.parseDouble(partes[0]);
                var weight = Double.parseDouble(partes[1]);
                items.add(new Item(weight, value));
            }

            return new MochilaInfo(weightOfBag, items);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<String> listarArquivos(String caminhoArquivos) {
        return Arrays.asList(new File(caminhoArquivos).list());
    }
}
