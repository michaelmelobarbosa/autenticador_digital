package app;

import estruturas.Arvore;
import estruturas.No;
import servico.LeitorDeDocumentos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aplicativo {
    public static void main(String[] args) {

        String path = "AutenticadorDigital.txt";

        LeitorDeDocumentos leitorDeDocumentos = new LeitorDeDocumentos();
        List<String> listaPalavras = leitorDeDocumentos.leitorDeArquivo(path);
        Collections.reverse(listaPalavras);

        Arvore arvore = new Arvore();
        No no = new No(listaPalavras.get(listaPalavras.size() - 1));

        for (int i = 0; i < listaPalavras.size(); i++) {
            arvore.inserir(new No(listaPalavras.get(i)));
        }


        arvore.imprimirInOrder();


    }
}
