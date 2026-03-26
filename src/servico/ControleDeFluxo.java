package servico;

import estruturas.Arvore;
import estruturas.ListaDinamica;
import estruturas.PilhaArvore;

public class ControleDeFluxo {

    public void processar(String path){
        LeitorDeDocumentos leitorDeDocumentos = new LeitorDeDocumentos();
        PilhaArvore pilhaArvore = leitorDeDocumentos.leitorDeArquivo(path);

        while (!pilhaArvore.estaVazia()) {
            Arvore arvore = pilhaArvore.pop();
            String hash = arvore.gerarHashRaiz();
            System.out.println(hash);
        }
    }
}
