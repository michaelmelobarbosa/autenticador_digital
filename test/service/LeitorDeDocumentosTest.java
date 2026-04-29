package service;

import estruturas.ArvoreAVL;
import estruturas.Pilha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.AfterEach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class LeitorDeDocumentosTest {

    private LeitorDeDocumentos leitor;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        leitor = new LeitorDeDocumentos();
    }

    @Test
    @DisplayName("Deve ler arquivo e retornar pilha com árvores")
    void deveLerArquivoRetornarPilha(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("banana maçã\n");
            writer.write("carro\n");
        }

        Pilha pilha = leitor.leitorDeArquivo(arquivo.getAbsolutePath());

        assertEquals(2, pilha.tamanho());
    }

    @Test
    @DisplayName("Deve ignorar linhas vazias")
    void deveIgnorarLinhasVazias(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("linha1\n");
            writer.write("\n");
            writer.write("linha2\n");
            writer.write("   \n");
        }

        Pilha pilha = leitor.leitorDeArquivo(arquivo.getAbsolutePath());

        assertEquals(2, pilha.tamanho());
    }

    @Test
    @DisplayName("Deve inserir palavras em ordem reversa na árvore")
    void deveInserirPalavrasOrdemReversa(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("um dois tres\n");
        }

        Pilha pilha = leitor.leitorDeArquivo(arquivo.getAbsolutePath());
        ArvoreAVL arvore = pilha.desempilhar();

        assertNotNull(arvore.getRaiz());
        assertEquals("tres", arvore.getRaiz().getValor());
    }

    @Test
    @DisplayName("Deve processar arquivo com múltiplas palavras")
    void deveProcessarArquivoMultiplasPalavras(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("banana maçã uva manga\n");
        }

        Pilha pilha = leitor.leitorDeArquivo(arquivo.getAbsolutePath());
        ArvoreAVL arvore = pilha.desempilhar();

        assertNotNull(arvore.getRaiz());
    }

    @Test
    @DisplayName("Deve retornar pilha vazia para arquivo inexistente")
    void deveRetornarPilhaVaziaArquivoInexistente() {
        Pilha pilha = leitor.leitorDeArquivo("arquivo_inexistente.txt");

        assertTrue(pilha.estaVazia());
    }

    @Test
    @DisplayName("Deve processar arquivo com apenas uma palavra")
    void deveProcessarArquivoUmaPalavra(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("palavra\n");
        }

        Pilha pilha = leitor.leitorDeArquivo(arquivo.getAbsolutePath());

        assertEquals(1, pilha.tamanho());
    }

    @Test
    @DisplayName("Deve tratar arquivo com espaços extras entre palavras")
    void deveTratarEspacosExtras(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("palavra1    palavra2   palavra3\n");
        }

        Pilha pilha = leitor.leitorDeArquivo(arquivo.getAbsolutePath());
        ArvoreAVL arvore = pilha.desempilhar();

        assertNotNull(arvore.getRaiz());
    }
}