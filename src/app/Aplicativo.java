package app;

import servico.LeitorDeDocumentos;

import java.util.List;

public class Aplicativo {
    public static void main(String[] args) {

        String path = "AutenticadorDigital.txt";

        LeitorDeDocumentos leitorDeDocumentos = new LeitorDeDocumentos();
        List<String> palavras = leitorDeDocumentos.leitorDeArquivo(path);
        System.out.println(palavras);

    }
}
