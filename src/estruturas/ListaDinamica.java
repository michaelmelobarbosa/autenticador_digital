package estruturas;


import java.util.Iterator;
import java.util.function.Consumer;


public class ListaDinamica<T> implements Iterable<T> {

    private NoLista<T> inicio;
    private NoLista<T> fim;
    private int tamanho;

    public void add(T valor) {
        NoLista<T> novo = new NoLista<>(valor);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
        tamanho++;
    }

    public void remove(int indice){
        validarIndice(indice);

        if (indice == 0){
            inicio = inicio.getProximo();
            if (inicio == null){
                fim = null;
            }

            tamanho--;
            return;
        }
        NoLista<T> anterior = inicio;
        for (int i = 0; i < indice - 1; i++) {
            anterior = anterior.getProximo();
        }

        NoLista<T> removido = anterior.getProximo();
        anterior.setProximo(removido.getProximo());

        if (removido == fim) {
            fim = anterior;
        }

        tamanho--;
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    private void validarIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido: " + indice);
        }
    }

    public T get(int indice) {
        validarIndice(indice);

        NoLista<T> atual = inicio;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        return atual.getValor();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaIterator();
    }

    public void forEachReverso(Consumer<T> acao) {
        if (isEmpty()) return;

        NoLista<T>[] array = (NoLista<T>[]) new NoLista[tamanho];
        NoLista<T> atual = inicio;
        for (int i = 0; i < tamanho; i++) {
            array[i] = atual;
            atual = atual.getProximo();
        }

        for (int i = tamanho - 1; i >= 0; i--) {
            acao.accept(array[i].getValor());
        }
    }

    @Override
    public String toString() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(get(i));
        }

        return "";
    }

    private class ListaIterator implements Iterator<T> {
        private NoLista<T> atual = inicio;

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
