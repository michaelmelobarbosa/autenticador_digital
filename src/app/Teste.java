package app;

import estruturas.ListaDinamica;

public class Teste {

    public static void main(String[] args) {

        ListaDinamica<String> nomes = new ListaDinamica<>();

        nomes.adicionar("mike");
        nomes.adicionar("evna");
        nomes.adicionar("bentinho");
        nomes.remover(0);

        System.out.println(nomes.size());

    }
}
