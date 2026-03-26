package estruturas;


import util.GeradorHashSHA1;
import java.util.ArrayList;


public class Arvore {

    private NoArvore raiz;

    public Arvore(ArrayList<String> hashes){
        construir(hashes);
      {
        
    private void contruir(ArrayList<String> hashes){
        ArrayList<NoArvore> nos = new ArrayList<>();

        for (String h : hashes) {
            nos.add(new NoArvore(h));

        }

        while (nos.size() > 1) {
            ArrayList<NoArvore> novos = new ArrayList<>();

            for (int i = 0; i < nos.size(); i += 2) {
                NoArvore esquerda = nos.get(i);
                NoArvore direita;
                
                if (i + 1 < nos.size())
                    direita = nos.get(i + 1);

                else
                    direita = esquerda;

                String hashPai =
                             GeradorHashSHA1.gerarHash(
                                     esquerda.hash + direita.hash
                             );

             NoArvore pai = new NoArvore(hashPai);

             pai.esquerda = esquerda;
             pai.direita = direita;
             
             novos.add(pai);
            }
            nos = novos;
        }

        raiz = nos.get(0);

    }   
 
    public String getHashFinal() {
        return raiz.hash;
    }

}
        this.raiz = null;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public NoArvore getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore raiz) {
        this.raiz = raiz;
    }

    private int altura(NoArvore no) {
        if (no == null) {
            return 0;
        }
        return no.getAltura();
    }

    private int fatorBalanceamento(NoArvore no) {
        if (no == null) {
            return 0;
        }
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    private void atualizarAltura(NoArvore no) {
        if (no == null) {
            return;
        }

        int alturaEsq = altura(no.getEsquerda());
        int alturaDir = altura(no.getDireita());
        no.setAltura(Math.max(alturaEsq, alturaDir) + 1);
    }

    private NoArvore rotacaoDireita(NoArvore no) {
        NoArvore x = no.getEsquerda();
        NoArvore T2 = x.getDireita();

        x.setDireita(no);
        no.setEsquerda(T2);

        atualizarAltura(no);
        atualizarAltura(x);

        return x;
    }

    private NoArvore rotacaoEsquerda(NoArvore no) {
        NoArvore y = no.getDireita();
        NoArvore T2 = y.getEsquerda();

        y.setEsquerda(no);
        no.setDireita(T2);

        atualizarAltura(no);
        atualizarAltura(y);
    
        private void calcularHash(NoArvore no){
            if (no == null) return;
            String hashEsq = (no.getEsquerda() != null)
            ? no.getEsquerda().hash
            : "";

            String hashDir = (no.getDireita() != null)
            ? no.get.Direita().hash
            : "";
            
            String combinado = hashEsq + hashDir + no.valor;
            no.hash = GeradorHasSHA1.gerarHash(combinado);
        }

        return y;
    }

    private NoArvore balancear(NoArvore no) {
        atualizarAltura(no);
        int fb = fatorBalanceamento(no);

        if (fb > 1) {
            if (fatorBalanceamento(no.getEsquerda()) < 0) {
                no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            }
            return rotacaoDireita(no);
        }

        if (fb < -1) {
            if (fatorBalanceamento(no.getDireita()) > 0) {
                no.setDireita(rotacaoDireita(no.getDireita()));
            }
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void inserir(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return;
        }
        this.raiz = inserirRec(this.raiz, valor.trim());
    }

    private NoArvore inserirRec(NoArvore atual, String novoValor) {
        if (atual == null) {
            return new NoArvore(novoValor);
        }

        int comparacao = novoValor.compareToIgnoreCase(atual.getValor());

        if (comparacao < 0) {
            atual.setEsquerda(inserirRec(atual.getEsquerda(), novoValor));
        } else if (comparacao > 0) {
            atual.setDireita(inserirRec(atual.getDireita(), novoValor));
        } else {
            return atual;
        }

        return balancear(atual);
    }

    public void imprimirInOrder() {
        imprimirInOrder(this.raiz);
    }

    private void imprimirInOrder(NoArvore atual) {
        if (atual == null) {
            return;
        }
        imprimirInOrder(atual.getEsquerda());
        System.out.println(atual.getValor());
        imprimirInOrder(atual.getDireita());
    }
}