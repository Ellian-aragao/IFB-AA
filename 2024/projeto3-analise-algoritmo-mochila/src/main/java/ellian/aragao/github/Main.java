package ellian.aragao.github;

import ellian.aragao.github.utils.LeitorDeArquivos;

public class Main {
    public static void main(String[] args) {
//        AlgoritmoRunner.run();
        System.out.println(new LeitorDeArquivos().listarArquivos("./data/large_scale"));
    }
}