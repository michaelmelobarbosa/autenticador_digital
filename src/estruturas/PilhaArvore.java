package estruturas;

import java.util.EmptyStackException;

public class PilhaArvore {

    private NoPilha topo;
    public int tamanho;


    public PilhaArvore() {
        topo = null;
    }


    public void push(Arvore arvoreDaLinha) {
        NoPilha novoElemento = new NoPilha(arvoreDaLinha);
        novoElemento.proximo = topo;
        topo = novoElemento;
        tamanho++;
    }


    public Arvore pop() {
        if(estaVazia()){
            throw new EmptyStackException();
        }

        Arvore removida = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return removida;
    }

    public boolean estaVazia(){
        return topo == null;
    }

    public Arvore peek(){
        if(estaVazia()){
            throw new EmptyStackException();
        }
        return topo.dado;
    }

    public int tamanho(){
        return tamanho;
    }


}
