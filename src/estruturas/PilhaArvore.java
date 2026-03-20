package estruturas;

import java.util.EmptyStackException;

public class PilhaArvore {

    // topo da pilha
    private NoPilha topo;

    //Nó da pilha, guarda uma árvore
    private class NoPilha {
        Arvore dado;
        NoPilha proximo;

        NoPilha(Arvore dado) {
            this.dado = dado;
        }
    }

    public PilhaArvore() {
        topo = null;
    }

    //Coloca uma árvore na pilha
    public void empilhar(Arvore arvoreDaLinha) {
        NoPilha novoElemento = new NoPilha(arvoreDaLinha);
        novoElemento.proximo = topo;
        topo = novoElemento;
    }

    //Remove o elemento do topo
    public Arvore desempilhar() {
        if(estaVazia()){
            throw new EmptyStackException(); //dispara o erro, caso a pilha esteja vazia e tentarem desempilhar
        }

        Arvore removida = topo.dado;
        topo = topo.proximo;

        return removida;
    }

    public boolean estaVazia(){
        return topo == null;
    }
}
