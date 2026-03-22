package app;

import util.Encriptador;

import java.security.NoSuchAlgorithmException;

public class Teste {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Encriptador en = new Encriptador();

        System.out.println(en.criptografarTexto("barbosa"));
    }
}
