package ellian.aragao.github.algoritmo;

public class MochilaGulosaPeso {
    public static void main(String[] args) {
        // Definição dos itens (weight e valor)
        Item[] itens = {
                new Item(5, 10),
                new Item(3, 20),
                new Item(2, 15),
                new Item(4, 30),
                new Item(6, 40)
        };

        // Definição da capacidade da mochila
        int capacidadeMochila = 10;

        // Inicialização do conjunto de itens na mochila
        boolean[] itensNaMochila = new boolean[itens.length];

        // Algoritmo guloso (priorizando pelo weight)
        for (int i = 0; i < itens.length; i++) {
            if (!itensNaMochila[i]) {
                int totalPeso = get_total_peso(itensNaMochila, itens);
                if (totalPeso + itens[i].getPeso() <= capacidadeMochila) {
                    itensNaMochila[i] = true;
                }
            }
        }

        // Cálculo do valor da mochila
        int totalValor = get_total_valor(itensNaMochila, itens);

        System.out.println("Total de valor: " + totalValor);
    }

    private static int get_total_peso(boolean[] itensNaMochila, Item[] itens) {
        int totalPeso = 0;
        for (int i = 0; i < itens.length; i++) {
            if (itensNaMochila[i]) {
                totalPeso += itens[i].getPeso();
            }
        }
        return totalPeso;
    }

    private static int get_total_valor(boolean[] itensNaMochila, Item[] itens) {
        int totalValor = 0;
        for (int i = 0; i < itens.length; i++) {
            if (itensNaMochila[i]) {
                totalValor += itens[i].getValor();
            }
        }
        return totalValor;
    }

    private static class Item {
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
}
