package app;

import estruturas.ListaDinamica;
import service.ControleDeFluxo;

public class Aplicativo {
    public static void main(String[] args) {

        String path = "AutenticadorDigital.txt";

        System.out.println("\n####----AUTENTICADOR DIGITAL----####\n");
        System.out.println("Gerando hashs do documento... \n");

        ControleDeFluxo controleDeFluxo = new ControleDeFluxo();
        ListaDinamica<String> hashs = controleDeFluxo.processar(path);

        for (String hash : hashs) {
            System.out.println(hash);
        }
        System.out.println("\n########--------FIM--------########");
    }
}
