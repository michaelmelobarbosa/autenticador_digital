package estruturas;

public class Arvore {
    private No no;


    public Arvore() {
        this.no = null;

    }

    public boolean isEmpty() {
        return this.no == null;
    }


    public void inserir(No novoNo){
        if (novoNo == null) {
            return;
        }

        if (isEmpty()) {
            this.no = novoNo;
            return;
        }

        inserirRec(this.no, novoNo);
    }

    public void inserirRec(No atual, No novoNo) {
        int comparacao = novoNo.getValor().compareToIgnoreCase(atual.getValor());

        if (comparacao < 0) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
            } else {
                inserirRec(atual.getEsquerda(), novoNo);
            }
        } else if (comparacao > 0) {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
            } else {
                inserirRec(atual.getDireita(), novoNo);
            }
        }
    }

   public void imprimirInOrder() {
       imprimirInOrder(this.no);
   }

   private void imprimirInOrder(No atual) {
       if (atual == null) {
           return;
       }
       imprimirInOrder(atual.getEsquerda());
       System.out.println(atual.getValor());
       imprimirInOrder(atual.getDireita());
   }



}
