package estruturas;

import util.GeradorHashSHA1;

public class ArvoreAVL {
    private No raiz;
    private final GeradorHashSHA1 geradorHash;


    public static class No {
        private String valor;
        private int altura;
        private No esquerda;
        private No direita;

        public No(String valor) {
            this.valor = valor;
            this.altura = 1;
            this.esquerda = null;
            this.direita = null;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public No getEsquerda() {
            return esquerda;
        }

        public void setEsquerda(No esquerda) {
            this.esquerda = esquerda;
        }

        public No getDireita() {
            return direita;
        }

        public void setDireita(No direita) {
            this.direita = direita;
        }
    }

    public ArvoreAVL() {
        this.raiz = null;
        this.geradorHash = new GeradorHashSHA1();
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public int tamanho() {
        return tamanho(raiz);
    }

    private int tamanho(No no) {
        if (no == null) return 0;
        return 1 + tamanho(no.getEsquerda()) + tamanho(no.getDireita());
    }

    private int altura(No no) {
        if (no == null) {
            return 0;
        }
        return no.getAltura();
    }

    private int fatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    private void atualizarAltura(No no) {
        if (no == null) {
            return;
        }

        int alturaEsq = altura(no.getEsquerda());
        int alturaDir = altura(no.getDireita());
        no.setAltura(Math.max(alturaEsq, alturaDir) + 1);
    }

    private No rotacaoDireita(No no) {
        No x = no.getEsquerda();
        No T2 = x.getDireita();

        x.setDireita(no);
        no.setEsquerda(T2);

        atualizarAltura(no);
        atualizarAltura(x);

        return x;
    }

    private No rotacaoEsquerda(No no) {
        No y = no.getDireita();
        No T2 = y.getEsquerda();

        y.setEsquerda(no);
        no.setDireita(T2);

        atualizarAltura(no);
        atualizarAltura(y);

        return y;
    }

    private No balancear(No no) {
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

    private No inserirRec(No atual, String novoValor) {
        if (atual == null) {
            return new No(novoValor);
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

    private void imprimirInOrder(No atual) {
        if (atual == null) {
            return;
        }
        imprimirInOrder(atual.getEsquerda());
        System.out.println(atual.getValor());
        imprimirInOrder(atual.getDireita());
    }

    public String gerarHashRaiz() {
        if (this.raiz == null) {
            return null;
        }
        return calcularBaixoParaCima(this.raiz);
    }

    private String calcularBaixoParaCima(No no) {
        if (no == null) {
            return null;
        }

        String hashEsq = calcularBaixoParaCima(no.getEsquerda());
        String hashDir = calcularBaixoParaCima(no.getDireita());
        String hashProprio = geradorHash.hashTexto(no.getValor());


        if (hashEsq == null && hashDir == null) {
            return hashProprio;
        }

        if (hashEsq != null && hashDir == null) {
            return geradorHash.hashTexto(hashEsq + hashProprio);
        }

        if (hashEsq == null && hashDir != null) {
            return geradorHash.hashTexto(hashProprio + hashDir);
        }

        return geradorHash.hashTexto(hashEsq + hashDir + hashProprio);
    }
}