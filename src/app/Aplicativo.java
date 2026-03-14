package app;

import servico.LeituraDocumento;

import java.util.List;

public class Aplicativo {
    public static void main(String[] args) {

        String path = "AutenticadorDigital.txt";

        LeituraDocumento leituraDocumento = new LeituraDocumento();
        List<String> palavras = leituraDocumento.leitorDeArquivo(path);
        System.out.println(palavras);

    }
}
