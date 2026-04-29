package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GeradorHashSHA1Test {

    private GeradorHashSHA1 gerador;

    @BeforeEach
    void setUp() {
        gerador = new GeradorHashSHA1();
    }

    @Test
    @DisplayName("Deve gerar hash de 40 caracteres")
    void deveGerarHash40Caracteres() {
        String hash = gerador.hashTexto("teste");

        assertNotNull(hash);
        assertEquals(40, hash.length());
    }

    @Test
    @DisplayName("Deve gerar hash em lowercase")
    void deveGerarHashLowercase() {
        String hash = gerador.hashTexto("TESTE");

        assertEquals(hash, hash.toLowerCase());
        assertEquals(hash, hash.toUpperCase().toLowerCase());
    }

    @Test
    @DisplayName("Deve retornar hash consistente para mesma entrada")
    void deveRetornarHashConsistente() {
        String hash1 = gerador.hashTexto("hello");
        String hash2 = gerador.hashTexto("hello");

        assertEquals(hash1, hash2);
    }

    @Test
    @DisplayName("Deve gerar hashes diferentes para entradas diferentes")
    void deveGerarHashesDiferentes() {
        String hash1 = gerador.hashTexto("hello");
        String hash2 = gerador.hashTexto("world");

        assertNotEquals(hash1, hash2);
    }

    @Test
    @DisplayName("Deve gerar hash para string vazia")
    void deveGerarHashStringVazia() {
        String hash = gerador.hashTexto("");

        assertNotNull(hash);
        assertEquals(40, hash.length());
    }

    @Test
    @DisplayName("Deve lançar exceção para texto null")
    void deveLancarExcecaoTextoNull() {
        assertThrows(IllegalArgumentException.class, () -> gerador.hashTexto(null));
    }

    @Test
    @DisplayName("Deve conter apenas caracteres hexadecimais")
    void deveConterApenasHexadecimais() {
        String hash = gerador.hashTexto("teste");

        assertTrue(hash.matches("[0-9a-f]+"));
    }

    @Test
    @DisplayName("Deve gerar hash de 40 caracteres para entrada conhecida")
    void deveGerarHashConhecido() {
        String hash = gerador.hashTexto("teste");

        assertNotNull(hash);
        assertEquals(40, hash.length());
        assertTrue(hash.matches("[0-9a-f]+"));
    }

    @Test
    @DisplayName("Deve gerar hash diferente para diferença de caso")
    void deveGerarHashDiferenteParaDiferencaDeCaso() {
        String hash1 = gerador.hashTexto("Hello");
        String hash2 = gerador.hashTexto("hello");

        assertNotEquals(hash1, hash2);
    }

    @Test
    @DisplayName("Deve gerar hash para texto longo")
    void deveGerarHashTextoLongo() {
        String textoLongo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        String hash = gerador.hashTexto(textoLongo);

        assertNotNull(hash);
        assertEquals(40, hash.length());
    }

    @Test
    @DisplayName("Deve gerar hash para texto com espaços")
    void deveGerarHashComEspacos() {
        String hash = gerador.hashTexto("teste com espacos");

        assertNotNull(hash);
        assertEquals(40, hash.length());
    }

    @Test
    @DisplayName("Deve gerar hash para texto com caracteres especiais")
    void deveGerarHashCaracteresEspeciais() {
        String hash = gerador.hashTexto("teste@#$%");

        assertNotNull(hash);
        assertEquals(40, hash.length());
    }
}