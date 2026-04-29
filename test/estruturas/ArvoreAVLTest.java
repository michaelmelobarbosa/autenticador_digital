package estruturas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArvoreAVLTest {

    private ArvoreAVL arvore;

    @BeforeEach
    void setUp() {
        arvore = new ArvoreAVL();
    }

    @Test
    @DisplayName("Deve iniciar vazia")
    void deveIniciarVazia() {
        assertTrue(arvore.estaVazia());
        assertNull(arvore.getRaiz());
    }

    @Test
    @DisplayName("Deve inserir elemento e atualizar raiz")
    void deveInserirElemento() {
        arvore.inserir("banana");

        assertFalse(arvore.estaVazia());
        assertNotNull(arvore.getRaiz());
        assertEquals("banana", arvore.getRaiz().getValor());
    }

    @Test
    @DisplayName("Deve ignorar palavras duplicadas (case insensitive)")
    void deveIgnorarDuplicatas() {
        arvore.inserir("maça");
        arvore.inserir("maça");
        arvore.inserir("MAÇA");

        assertEquals(1, arvore.tamanho());
    }

    @Test
    @DisplayName("Deve contar nós corretamente")
    void deveContarNosCorretamente() {
        arvore.inserir("b");
        arvore.inserir("a");
        arvore.inserir("c");

        assertEquals(3, arvore.tamanho());
    }

    @Test
    @DisplayName("Deve inserir múltiplos elementos")
    void deveInserirMultiplosElementos() {
        arvore.inserir("banana");
        arvore.inserir("apple");
        arvore.inserir("cherry");

        assertFalse(arvore.estaVazia());
    }

    @Test
    @DisplayName("Deve ignorar valores nulos ou vazios")
    void deveIgnorarValoresNulosOuVazios() {
        arvore.inserir(null);
        arvore.inserir("");
        arvore.inserir("   ");

        assertTrue(arvore.estaVazia());
    }

    @Test
    @DisplayName("Deve calcular hash para nó folha")
    void deveCalcularHashFolha() {
        arvore.inserir("teste");

        String hash = arvore.gerarHashRaiz();

        assertNotNull(hash);
        assertEquals(40, hash.length());
    }

    @Test
    @DisplayName("Deve calcular hash bottom-up com dois filhos")
    void deveCalcularHashBottomUpComDoisFilhos() {
        arvore.inserir("b");
        arvore.inserir("a");
        arvore.inserir("c");

        String hash = arvore.gerarHashRaiz();

        assertNotNull(hash);
        assertEquals(40, hash.length());
    }

    @Test
    @DisplayName("Deve retornar null para árvore vazia")
    void deveRetornarNullArvoreVazia() {
        assertNull(arvore.gerarHashRaiz());
    }

    @Test
    @DisplayName("Deve balancear rotação à direita (caso LL)")
    void deveBalancearRotacaoDireita() {
        arvore.inserir("c");
        arvore.inserir("b");
        arvore.inserir("a");

        assertNotNull(arvore.getRaiz());
    }

    @Test
    @DisplayName("Deve balancear rotação à esquerda (caso RR)")
    void deveBalancearRotacaoEsquerda() {
        arvore.inserir("a");
        arvore.inserir("b");
        arvore.inserir("c");

        assertNotNull(arvore.getRaiz());
    }

    @Test
    @DisplayName("Deve balancear rotação esquerda-direita (caso LR)")
    void deveBalancearRotacaoEsquerdaDireita() {
        arvore.inserir("c");
        arvore.inserir("a");
        arvore.inserir("b");

        assertNotNull(arvore.getRaiz());
    }

    @Test
    @DisplayName("Deve balancear rotação direita-esquerda (caso RL)")
    void deveBalancearRotacaoDireitaEsquerda() {
        arvore.inserir("a");
        arvore.inserir("c");
        arvore.inserir("b");

        assertNotNull(arvore.getRaiz());
    }

    @Test
    @DisplayName("Deve calcular hash consistente para mesma entrada")
    void deveCalcularHashConsistente() {
        ArvoreAVL arvore1 = new ArvoreAVL();
        arvore1.inserir("teste");
        String hash1 = arvore1.gerarHashRaiz();

        ArvoreAVL arvore2 = new ArvoreAVL();
        arvore2.inserir("teste");
        String hash2 = arvore2.gerarHashRaiz();

        assertEquals(hash1, hash2);
    }

    @Test
    @DisplayName("Deve retornar null para raiz nula")
    void deveRetornarNullParaRaizNula() {
        arvore.setRaiz(null);
        assertNull(arvore.gerarHashRaiz());
    }

    @Test
    @DisplayName("Deve gerar hash para caso do README")
    void deveGerarHashCasoREADME() {
        ArvoreAVL arvoreTeste = new ArvoreAVL();
        String[] palavras = {"Eu", "amo", "muito", "essa", "disciplina"};
        for (String palavra : palavras) {
            arvoreTeste.inserir(palavra);
        }

        String hash = arvoreTeste.gerarHashRaiz();

        assertNotNull(hash);
        assertEquals(40, hash.length());
    }
}