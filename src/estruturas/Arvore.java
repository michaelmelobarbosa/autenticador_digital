package estruturas;

public class Arvore {
    private No no;
    private Arvore esquerda;
    private Arvore direita;

    public Arvore() {
        this.no = null;
        this.esquerda = null;
        this.direita = null;
    }

    public Arvore(No no) {
        this.no = no;
        this.esquerda = null;
        this.direita = null;
    }


    public boolean isEmpty() {
        return this.no == null;
    }

    public void inserir(No novo) {
        int comparacao = novo.getValor().compareToIgnoreCase(this.no.getValor());

        if (isEmpty()) {
            this.no = novo;
        } else {
            Arvore novaArvore = new Arvore(novo);
            if (comparacao < 0) {
                if (this.esquerda == null) {
                    this.esquerda = novaArvore;
                } else {
                    this.esquerda.inserir(novo);
                }
            } else if (comparacao > 0) {
                if (this.direita == null) {
                    this.direita = novaArvore;
                } else {
                    this.direita.inserir(novo);
                }
            }
        }
    }

}
