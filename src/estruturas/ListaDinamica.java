package estruturas;


public class ListaDinamica<T> {

    private NoLista<T> inicio;
    private NoLista<T> fim;
    private int tamanho;

    public void adicionar(T valor) {
        NoLista<T> novo = new NoLista<>(valor);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
        tamanho++;
    }

    public void remover(int indice){
        validarIndice(indice);

        if (indice == 0){
            inicio = inicio.proximo;
            if (inicio == null){
                fim = null;
            }

            tamanho--;
            return;
        }
        NoLista<T> anterior = inicio;
        for (int i = 0; i < indice - 1; i++) {
            anterior = anterior.proximo;
        }

        NoLista<T> removido = anterior.proximo;
        anterior.proximo = removido.proximo;

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
            atual = atual.proximo;
        }
        return atual.valor;
    }

    @Override
    public String toString() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(get(i));
        }

        return "";
    }
}
