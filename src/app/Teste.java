package app;

import estruturas.ListaDinamica;

public class Teste {

    public static void main(String[] args) {

        ListaDinamica<String> nomes = new ListaDinamica<>();

        nomes.add("mike");
        nomes.add("evna");
        nomes.add("bentinho");
        nomes.remove(0);

        System.out.println(nomes.size());

    }
}
