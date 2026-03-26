import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader; 
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList; 
import java.security.MessageDigest;

public class Leitura_Documento { 

    public static String gerarSHA1(String texto) {

     try { MessageDigest md = MessageDigest.getInstance("SHA-1");
      byte[] bytes = md.digest(texto.getBytes());

    StringBuilder sb = new StringBuilder();

    for (byte b : bytes) {
         sb.append(String.format("%02x", b)); 
    } 
         
         return sb.toString(); 
        
    } catch (Exception e) {
             throw new RuntimeException(e);
            
    } 
  }
          public static void main(String[] args) {
            
            String path = "AutenticadorDigital.txt"; 
            
             ArrayList<String> palavras = new ArrayList<>();
             
             try { 
                BufferedReader ler  = new BufferedReader(new FileReader (path));
                String linha;

                while ((linha = ler.readLine()) != null) {
                    String[] partes = linha.split(" ");
                 for (String p : partes) {
                    palavras.add(p);
                 }
                }

                ler.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
             ArrayList<String> hashes = new ArrayList<>();
             for ( String palavra : palavras) {
                 hashes.add(gerarSHA1(palavra));
             }

             String pai = "0";

            while (hashes.size() > 1) {

                ArrayList<String> novaLista = new ArrayList<>();
               for (int i = 0; i < hashes.size(); i += 2) {

                if (i + 1 < hashes.size()){ 

                    String A = hashes.get(i);
                    String B = hashes.get(i + 1);

                    String combinado = A + B + pai;
                    
                    String novoHash = gerarSHA1(combinado);

                    novaLista.add(novoHash);

                    pai = novoHash;
                } else {
                    novaLista.add(hashes.get(i));
                }
            } 

          hashes = novaLista;
        }
   
       
         System.out.println("Hash final (raiz): " + hashes.get(0)); 
         }
        }