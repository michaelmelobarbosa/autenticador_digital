package servico;

import estruturas.Arvore;
import estruturas.ListaDinamica;
import estruturas.PilhaArvore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDeDocumentos {


    public PilhaArvore leitorDeArquivo(String path) {
        PilhaArvore pilhaArvore = new PilhaArvore();

        try (BufferedReader ler_Arquivo = new BufferedReader(new FileReader(path))) {

            String linha;

            while ((linha = ler_Arquivo.readLine()) != null) {

                if(linha.trim().isEmpty()) continue;
                Arvore arvoreDaLinha = new Arvore();

                String[] palavras = linha.split("\\s+");

                ListaDinamica<String> linhaTratada = new ListaDinamica<>();

                for (String palavra : palavras) {
                    linhaTratada.add(palavra);
                }

                for (int i = linhaTratada.size() - 1; i >= 0; i--) {
                    arvoreDaLinha.inserir(linhaTratada.get(i));
                }

                pilhaArvore.push(arvoreDaLinha);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return pilhaArvore;
    }
}
