import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura_Documento {
    public static void main(String[] args) {

        String path = "Autentificador_Digital.txt";

        try {
            BufferedReader ler_Arquivo = new BufferedReader(new FileReader(path));

            // VARIAVEL DO TIPO STRING QUE VAI RECEBER AS LINHAS
            String linha;

            // A LISTA DINAMICA QUE VAI RECEBER OS DADOS
            ArrayList<String> palavras = new ArrayList<String>();

            // O LAÇO DE REPETIÇÃO QUE VAI LER TODO O ARQUIVO .TXT, ADICIONANDO CADA LINHA
            // LIDA, NA VARIALVEL LINHA
            while ((linha = ler_Arquivo.readLine()) != null) {
                // System.out.println("Linha: " + i + "\n" + linha + "\n");
                // ARRAY DE STRING QUE VAI RECEBER AS PALAVRAS SEPARADAS DE CADA LINHA
                String[] palavas_linha = linha.split(" ");

                for (String indice_palavra : palavas_linha) {
                    palavras.add(indice_palavra);
                }

                // System.out.println("Linha" + " " + i + "\n" + linha + "\n");
                // i++;
            }
            System.out.println(palavras);
            ler_Arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
