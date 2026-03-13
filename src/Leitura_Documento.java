import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura_Documento {
    public static void main(String[] args) {

        String path = "AutenticadorDigital.txt";

        try {
            BufferedReader ler_Arquivo = new BufferedReader(new FileReader(path));
            String linha;
            ArrayList<String> palavras = new ArrayList<String>();

            while ((linha = ler_Arquivo.readLine()) != null) {
                String[] palavas_linha = linha.split(" ");
                for (String indice_palavra : palavas_linha) {
                    palavras.add(indice_palavra);
                }
            }
            System.out.println(palavras);
            ler_Arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
