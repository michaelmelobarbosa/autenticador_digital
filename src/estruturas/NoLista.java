package estruturas;

public class NoLista<T> {

    public T valor;
    public NoLista<T> proximo;

    public NoLista(T valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "NoLista{" +
                "valor=" + valor +
                ", proximo=" + proximo +
                '}';
    }
}
