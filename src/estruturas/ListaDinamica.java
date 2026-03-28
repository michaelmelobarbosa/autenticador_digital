package estruturas;


import java.util.Iterator;


public class ListaDinamica<T> implements Iterable<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;


    private class No<T> {

        private T valor;
        private No<T> proximo;

        public No(T valor) {
            this.valor = valor;
        }

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public No<T> getProximo() {
            return proximo;
        }

        public void setProximo(No<T> proximo) {
            this.proximo = proximo;
        }

    }
    

    public void adiciona(T valor) {
        No<T> novo = new No<>(valor);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
        tamanho++;
    }

    public void remove(int indice) {
        validarIndice(indice);

        if (indice == 0) {
            inicio = inicio.getProximo();
            if (inicio == null) {
                fim = null;
            }

            tamanho--;
            return;
        }
        No<T> anterior = inicio;
        for (int i = 0; i < indice - 1; i++) {
            anterior = anterior.getProximo();
        }

        No<T> removido = anterior.getProximo();
        anterior.setProximo(removido.getProximo());

        if (removido == fim) {
            fim = anterior;
        }

        tamanho--;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    private void validarIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido: " + indice);
        }
    }

    public T obter(int indice) {
        validarIndice(indice);

        No<T> atual = inicio;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        return atual.getValor();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaIterator();
    }


    @Override
    public String toString() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(obter(i));
        }

        return "";
    }

    private class ListaIterator implements Iterator<T> {
        private No<T> atual = inicio;

        @Override
        public boolean hasNext() {
            return atual != null;
        }

        @Override
        public T next() {
            T valor = atual.getValor();
            atual = atual.getProximo();
            return valor;
        }
    }

}
