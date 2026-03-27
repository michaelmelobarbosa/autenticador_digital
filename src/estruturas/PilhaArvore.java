package estruturas;

import java.util.EmptyStackException;

public class PilhaArvore {

    private NoPilha topo;
    private int tamanho;

    public PilhaArvore() {
        topo = null;
        tamanho = 0;
    }

    public void push(Arvore arvoreDaLinha) {
        NoPilha novoElemento = new NoPilha(arvoreDaLinha);
        novoElemento.setProximo(topo);
        topo = novoElemento;
        tamanho++;
    }

    public Arvore pop() {
        if(estaVazia()){
            throw new EmptyStackException();
        }

        Arvore removida = topo.getDado();
        topo = topo.getProximo();
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
        return topo.getDado();
    }

    public int tamanho(){
        return tamanho;
    }


}
