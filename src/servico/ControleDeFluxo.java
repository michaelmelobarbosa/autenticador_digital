package servico;

import estruturas.Arvore;
import estruturas.ListaDinamica;
import estruturas.PilhaArvore;

public class ControleDeFluxo {

    public ListaDinamica<String> processar(String path){
        LeitorDeDocumentos leitorDeDocumentos = new LeitorDeDocumentos();
        PilhaArvore pilhaArvore = leitorDeDocumentos.leitorDeArquivo(path);
        ListaDinamica<String> hashs = new ListaDinamica<>();

        while (!pilhaArvore.estaVazia()) {
            Arvore arvore = pilhaArvore.pop();
            String hash = arvore.gerarHashRaiz();
            hashs.add(hash);
        }
        return hashs;
    }
}
