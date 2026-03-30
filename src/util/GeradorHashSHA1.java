package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeradorHashSHA1 {

    public static String hashTexto(String texto){

        if (texto == null) {
            throw new IllegalArgumentException("Texto nao pode ser null");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[]  bytes = md.digest(texto.getBytes(StandardCharsets.UTF_8));

            StringBuilder hash = new StringBuilder();

            for (byte b : bytes) {
                hash.append(String.format("%02x", b & 0xff));
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 não disponível", e);
        }
    }
}
