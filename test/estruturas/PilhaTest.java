package estruturas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaTest {

    private Pilha pilha;

    @BeforeEach
    void setUp() {
        pilha = new Pilha();
    }

    @Test
    @DisplayName("Deve iniciar vazia")
    void deveIniciarVazia() {
        assertTrue(pilha.estaVazia());
        assertEquals(0, pilha.tamanho());
    }

    @Test
    @DisplayName("Deve empilhar elementos")
    void deveEmpilharElementos() {
        ArvoreAVL arvore1 = new ArvoreAVL();
        ArvoreAVL arvore2 = new ArvoreAVL();

        pilha.empilhar(arvore1);
        pilha.empilhar(arvore2);

        assertEquals(2, pilha.tamanho());
        assertFalse(pilha.estaVazia());
    }

    @Test
    @DisplayName("Deve desempilhar elemento")
    void deveDesempilharElemento() {
        ArvoreAVL arvore1 = new ArvoreAVL();
        ArvoreAVL arvore2 = new ArvoreAVL();

        pilha.empilhar(arvore1);
        pilha.empilhar(arvore2);

        ArvoreAVL desempilhado = pilha.desempilhar();

        assertEquals(arvore2, desempilhado);
        assertEquals(1, pilha.tamanho());
    }

    @Test
    @DisplayName("Deve seguir ordem LIFO (Last In First Out)")
    void deveSeguirOrdemLIFO() {
        ArvoreAVL arvore1 = new ArvoreAVL();
        arvore1.inserir("primeiro");
        ArvoreAVL arvore2 = new ArvoreAVL();
        arvore2.inserir("segundo");
        ArvoreAVL arvore3 = new ArvoreAVL();
        arvore3.inserir("terceiro");

        pilha.empilhar(arvore1);
        pilha.empilhar(arvore2);
        pilha.empilhar(arvore3);

        ArvoreAVL topo1 = pilha.desempilhar();
        assertEquals("terceiro", topo1.getRaiz().getValor());

        ArvoreAVL topo2 = pilha.desempilhar();
        assertEquals("segundo", topo2.getRaiz().getValor());

        ArvoreAVL topo3 = pilha.desempilhar();
        assertEquals("primeiro", topo3.getRaiz().getValor());
    }

    @Test
    @DisplayName("Deve lançar exceção ao desempilhar pilha vazia")
    void deveLancarExcecaoDesempilharPilhaVazia() {
        assertThrows(EmptyStackException.class, () -> pilha.desempilhar());
    }

    @Test
    @DisplayName("Deve lançar exceção ao ver topo de pilha vazia")
    void deveLancarExcecaoVerTopoPilhaVazia() {
        assertThrows(EmptyStackException.class, () -> pilha.verTopo());
    }

    @Test
    @DisplayName("Deve retornar o topo sem remover")
    void deveRetornarTopoSemRemover() {
        ArvoreAVL arvore1 = new ArvoreAVL();
        ArvoreAVL arvore2 = new ArvoreAVL();

        pilha.empilhar(arvore1);
        pilha.empilhar(arvore2);

        ArvoreAVL topo = pilha.verTopo();

        assertEquals(arvore2, topo);
        assertEquals(2, pilha.tamanho());
    }

    @Test
    @DisplayName("Deve atualizar tamanho corretamente")
    void deveAtualizarTamanho() {
        assertEquals(0, pilha.tamanho());

        pilha.empilhar(new ArvoreAVL());
        assertEquals(1, pilha.tamanho());

        pilha.empilhar(new ArvoreAVL());
        assertEquals(2, pilha.tamanho());

        pilha.desempilhar();
        assertEquals(1, pilha.tamanho());

        pilha.desempilhar();
        assertEquals(0, pilha.tamanho());
        assertTrue(pilha.estaVazia());
    }

    @Test
    @DisplayName("Deve retornar true para está vazia após esvaziar")
    void deveRetornarTrueEstaVaziaAposEsvaziar() {
        pilha.empilhar(new ArvoreAVL());
        assertFalse(pilha.estaVazia());

        pilha.desempilhar();
        assertTrue(pilha.estaVazia());
    }
}