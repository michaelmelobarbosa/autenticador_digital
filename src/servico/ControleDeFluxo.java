package servico;

import estruturas.ArvoreAVL;
import estruturas.ListaDinamica;
import estruturas.Pilha;

public class ControleDeFluxo {

    public ListaDinamica<String> processar(String path) {
        LeitorDeDocumentos leitorDeDocumentos = new LeitorDeDocumentos();
        Pilha pilha = leitorDeDocumentos.leitorDeArquivo(path);
        ListaDinamica<String> hashs = new ListaDinamica<>();

        while (!pilha.estaVazia()) {
            ArvoreAVL arvoreAVL = pilha.pop();
            String hash = arvoreAVL.gerarHashRaiz();
            hashs.add(hash);
        }
        return hashs;
    }
}
