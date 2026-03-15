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


    public void inserir(No novoNo) {
        if (isEmpty()) {
            this.no = novoNo;
            return;
        }

        int comparacao = novoNo.getValor().compareToIgnoreCase(this.no.getValor());
        if (comparacao < 0) {
            if (this.esquerda == null) {
                this.esquerda = new Arvore(novoNo);
            } else {
                this.esquerda.inserir(novoNo);
            }
        } else if (comparacao > 0) {
            if (this.direita == null) {
                this.direita = new Arvore(novoNo);
            } else {
                this.direita.inserir(novoNo);
            }
        }
    }

   public void imprimirInOrder() {
       imprimirInOrder(this);
   }

   private void imprimirInOrder(Arvore arvore) {
       if (arvore == null || arvore.isEmpty()) {
           return;
       }
       imprimirInOrder(arvore.esquerda);
       System.out.println(arvore.no.getValor());
       imprimirInOrder(arvore.direita);
   }



}
