package estruturas;

import java.util.EmptyStackException;

public class Pilha {

    private No topo;
    private int tamanho;


    private class No {
        private ArvoreAVL dado;
        private No proximo;

        public No(ArvoreAVL dado) {
            this.dado = dado;
        }

        public ArvoreAVL getDado() {
            return dado;
        }

        public void setDado(ArvoreAVL dado) {
            this.dado = dado;
        }

        public No getProximo() {
            return proximo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    }
    
    
    public Pilha() {
        topo = null;
        tamanho = 0;
    }

    public void push(ArvoreAVL arvoreAVLDaLinha) {
        No novoElemento = new No(arvoreAVLDaLinha);
        novoElemento.setProximo(topo);
        topo = novoElemento;
        tamanho++;
    }

    public ArvoreAVL pop() {
        if(estaVazia()){
            throw new EmptyStackException();
        }

        ArvoreAVL removida = topo.getDado();
        topo = topo.getProximo();
        tamanho--;
        return removida;
    }

    public boolean estaVazia(){
        return topo == null;
    }

    public ArvoreAVL peek(){
        if(estaVazia()){
            throw new EmptyStackException();
        }
        return topo.getDado();
    }

    public int tamanho(){
        return tamanho;
    }


}
