package servico;

import estruturas.Arvore;
import estruturas.No;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeDocumentos {


    public List<Arvore> leitorDeArquivo(String path) {
        List<Arvore> arvores = new ArrayList<>();

        try (BufferedReader ler_Arquivo = new BufferedReader(new FileReader(path))) {

            String linha;

            while ((linha = ler_Arquivo.readLine()) != null) {
                Arvore arvore = new Arvore();

                String[] palavras = linha.split("\\s+");

                List<String> linhaTratada = new ArrayList<>();

                for (String palavra : palavras) {
                    linhaTratada.add(palavra);
                }

                for (int i = linhaTratada.size() - 1; i >= 0; i--) {
                    arvore.inserir(String.valueOf(new No(linhaTratada.get(i))));
                }

                arvores.add(arvore);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return arvores;
    }
}
