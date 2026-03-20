package estruturas;

import java.util.EmptyStackException;

public class PilhaArvore {

    private NoPilha topo;


    public PilhaArvore() {
        topo = null;
    }


    public void empilhar(Arvore arvoreDaLinha) {
        NoPilha novoElemento = new NoPilha(arvoreDaLinha);
        novoElemento.proximo = topo;
        topo = novoElemento;
    }


    public Arvore desempilhar() {
        if(estaVazia()){
            throw new EmptyStackException();
        }

        Arvore removida = topo.dado;
        topo = topo.proximo;

        return removida;
    }

    public boolean estaVazia(){
        return topo == null;
    }
}
