package servico;

import estruturas.Arvore;
import estruturas.ListaDinamica;
import estruturas.NoArvore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeDocumentos {


    public ListaDinamica<Arvore> leitorDeArquivo(String path) {
        ListaDinamica<Arvore> arvores = new ListaDinamica<>();

        try (BufferedReader ler_Arquivo = new BufferedReader(new FileReader(path))) {

            String linha;

            while ((linha = ler_Arquivo.readLine()) != null) {
                Arvore arvore = new Arvore();

                String[] palavras = linha.split("\\s+");

                ListaDinamica<String> linhaTratada = new ListaDinamica<>();

                for (String palavra : palavras) {
                    linhaTratada.adicionar(palavra);
                }

                for (int i = linhaTratada.size() - 1; i >= 0; i--) {
                    arvore.inserir(String.valueOf(new NoArvore(linhaTratada.get(i))));
                }

                arvores.adicionar(arvore);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return arvores;
    }
}
