package app;

import estruturas.ListaDinamica;
import servico.ControleDeFluxo;

public class Aplicativo {
    public static void main(String[] args) {

        String path = "AutenticadorDigital.txt";

        System.out.println("####----AUTENTICADOR DIGITAL----####\n");
        System.out.println("Gerando hashs do documento... \n");

        ControleDeFluxo controleDeFluxo = new ControleDeFluxo();
        ListaDinamica<String> hashs = controleDeFluxo.processar(path);

        for (String hash : hashs) {
            System.out.println(hash);
        }

    }
}
