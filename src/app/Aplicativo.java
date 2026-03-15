package app;

import estruturas.Arvore;
import estruturas.No;
import servico.LeitorDeDocumentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aplicativo {
    public static void main(String[] args) {

        String path = "AutenticadorDigital.txt";

        LeitorDeDocumentos leitorDeDocumentos = new LeitorDeDocumentos();
        List<String> listaDePalavras = leitorDeDocumentos.leitorDeArquivo(path);
        Collections.reverse(listaDePalavras);
        Arvore arvore = new Arvore();

        for (String palavra : listaDePalavras) {
            arvore.inserir(new No(palavra));
        }

        arvore.imprimirInOrder();
    }
}
