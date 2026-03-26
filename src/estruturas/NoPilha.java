package estruturas;

public class NoPilha {
    private Arvore dado;
    private NoPilha proximo;

    public NoPilha(Arvore dado) {
        this.dado = dado;
    }

    public Arvore getDado() {
        return dado;
    }

    public void setDado(Arvore dado) {
        this.dado = dado;
    }

    public NoPilha getProximo() {
        return proximo;
    }

    public void setProximo(NoPilha proximo) {
        this.proximo = proximo;
    }
}