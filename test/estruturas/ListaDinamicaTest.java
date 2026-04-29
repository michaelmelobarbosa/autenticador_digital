package estruturas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ListaDinamicaTest {

    private ListaDinamica<String> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaDinamica<>();
    }

    @Test
    @DisplayName("Deve iniciar vazia")
    void deveIniciarVazia() {
        assertTrue(lista.estaVazia());
        assertEquals(0, lista.tamanho());
    }

    @Test
    @DisplayName("Deve adicionar elementos")
    void deveAdicionarElementos() {
        lista.adiciona("A");
        lista.adiciona("B");
        lista.adiciona("C");

        assertEquals(3, lista.tamanho());
        assertFalse(lista.estaVazia());
    }

    @Test
    @DisplayName("Deve obter elemento por índice")
    void deveObterElementoPorIndice() {
        lista.adiciona("Primeiro");
        lista.adiciona("Segundo");
        lista.adiciona("Terceiro");

        assertEquals("Primeiro", lista.obter(0));
        assertEquals("Segundo", lista.obter(1));
        assertEquals("Terceiro", lista.obter(2));
    }

    @Test
    @DisplayName("Deve remover elemento por índice")
    void deveRemoverElementoPorIndice() {
        lista.adiciona("A");
        lista.adiciona("B");
        lista.adiciona("C");

        lista.remove(1);

        assertEquals(2, lista.tamanho());
        assertEquals("A", lista.obter(0));
        assertEquals("C", lista.obter(1));
    }

    @Test
    @DisplayName("Deve remover primeiro elemento")
    void deveRemoverPrimeiroElemento() {
        lista.adiciona("A");
        lista.adiciona("B");
        lista.remove(0);

        assertEquals(1, lista.tamanho());
        assertEquals("B", lista.obter(0));
    }

    @Test
    @DisplayName("Deve remover último elemento")
    void deveRemoverUltimoElemento() {
        lista.adiciona("A");
        lista.adiciona("B");
        lista.remove(1);

        assertEquals(1, lista.tamanho());
        assertEquals("A", lista.obter(0));
    }

    @Test
    @DisplayName("Deve lançar exceção para índice inválido no obter")
    void deveLancarExcecaoIndiceInvalidoObter() {
        lista.adiciona("A");

        assertThrows(IndexOutOfBoundsException.class, () -> lista.obter(5));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.obter(-1));
    }

    @Test
    @DisplayName("Deve lançar exceção para índice inválido no remove")
    void deveLancarExcecaoIndiceInvalidoRemove() {
        lista.adiciona("A");

        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(5));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(-1));
    }

    @Test
    @DisplayName("Deve iterar com iterator")
    void deveIterarComIterator() {
        lista.adiciona("X");
        lista.adiciona("Y");
        lista.adiciona("Z");

        Iterator<String> it = lista.iterator();

        assertTrue(it.hasNext());
        assertEquals("X", it.next());
        assertTrue(it.hasNext());
        assertEquals("Y", it.next());
        assertTrue(it.hasNext());
        assertEquals("Z", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    @DisplayName("Deve funcionar com generics de diferentes tipos")
    void deveFuncionarComDifferentTypes() {
        ListaDinamica<Integer> listaInt = new ListaDinamica<>();
        listaInt.adiciona(10);
        listaInt.adiciona(20);
        listaInt.adiciona(30);

        assertEquals(3, listaInt.tamanho());
        assertEquals(Integer.valueOf(20), listaInt.obter(1));

        ListaDinamica<Double> listaDouble = new ListaDinamica<>();
        listaDouble.adiciona(1.5);
        listaDouble.adiciona(2.5);

        assertEquals(2, listaDouble.tamanho());
        assertEquals(Double.valueOf(1.5), listaDouble.obter(0));
    }

    @Test
    @DisplayName("Deve atualizar tamanho ao adicionar e remover")
    void deveAtualizarTamanho() {
        assertEquals(0, lista.tamanho());

        lista.adiciona("A");
        assertEquals(1, lista.tamanho());

        lista.adiciona("B");
        assertEquals(2, lista.tamanho());

        lista.remove(0);
        assertEquals(1, lista.tamanho());

        lista.remove(0);
        assertEquals(0, lista.tamanho());
        assertTrue(lista.estaVazia());
    }
}