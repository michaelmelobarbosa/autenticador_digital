package estruturas;

public class NoArvore {
    private String valor;
    private int altura;
    private NoArvore esquerda;
    private NoArvore direita;

    public NoArvore(String valor) {
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

    public NoArvore getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvore esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvore getDireita() {
        return direita;
    }

    public void setDireita(NoArvore direita) {
        this.direita = direita;
    }
}
