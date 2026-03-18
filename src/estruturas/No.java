package estruturas;

public class No {
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
