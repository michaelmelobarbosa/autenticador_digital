package app;

import service.LeitorDeDocumentos;
import estruturas.Arvore;

import java.util.ArrayList;


public class Aplicativo {
    public static void main(String[] args) {
        LeitorDeDocumentos leitorDeDocumentos = new LeitorDeDocumentos;
        ArrayList<String> hashes  =
               LeitorDeDocumentos.ler("AutenticadorDigital.txt");

                Arvore arvore = new Arvore(hashes);
                 System.out.println("HASH FINAL:");
                 System.out.printl(arvore.getHashFinal());
    

        String path = "AutenticadorDigital.txt";

        LeitorDeDocumentos path = new LeitorDeDocumentos();

    }
}
