package servico;

import estruturas.ArvoreAVL;
import estruturas.ListaDinamica;
import estruturas.Pilha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDeDocumentos {

    public Pilha leitorDeArquivo(String path) {
        Pilha pilha = new Pilha();

        try (BufferedReader ler_Arquivo = new BufferedReader(new FileReader(path))) {

            String linha;

            while ((linha = ler_Arquivo.readLine()) != null) {

                if (linha.trim().isEmpty()) continue;
                ArvoreAVL arvoreAVLDaLinha = new ArvoreAVL();

                String[] palavras = linha.split("\\s+");

                ListaDinamica<String> linhaTratada = new ListaDinamica<>();

                for (String palavra : palavras) {
                    linhaTratada.add(palavra);
                }

                for (int i = linhaTratada.size() - 1; i >= 0; i--) {
                    arvoreAVLDaLinha.inserir(linhaTratada.get(i));
                }

                pilha.push(arvoreAVLDaLinha);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return pilha;
    }
}
