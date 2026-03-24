package app;

import util.GeradorHashSHA1;

import java.security.NoSuchAlgorithmException;

public class Teste {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        GeradorHashSHA1 en = new GeradorHashSHA1();

        String texto = "Hello World!";

        System.out.println("Hash de " + texto + " é: " + en.hashTexto(texto));
    }
}
