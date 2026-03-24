package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeradorHashSHA1 {

    public String hashTexto(String texto) {

        if (texto == null) {
            throw new IllegalArgumentException("Texto nao pode ser null");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] digest = md.digest(texto.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 não disponível", e);
        }
    }
}
