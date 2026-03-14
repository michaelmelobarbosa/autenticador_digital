package servico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeituraDocumento {
    public static void main(String[] args) {

        String path = "AutenticadorDigital.txt";

        try {
            BufferedReader ler_Arquivo = new BufferedReader(new FileReader(path));
            String linha;
            ArrayList<String> palavras = new ArrayList<String>();

            while ((linha = ler_Arquivo.readLine()) != null) {

                Pattern pattern = Pattern.compile("[\\p{L}]+");
                Matcher matcher = pattern.matcher(linha);

                while (matcher.find()) {
                    palavras.add(matcher.group());
                }

            }
            System.out.println(palavras);
            ler_Arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
