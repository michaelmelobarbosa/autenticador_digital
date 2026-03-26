package estruturas;

public class NoLista<T> {

    private T valor;
    private NoLista<T> proximo;

    public NoLista(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "NoLista{" +
                "valor=" + valor +
                ", proximo=" + proximo +
                '}';
    }
}
