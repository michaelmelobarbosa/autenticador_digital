package service;

import estruturas.ListaDinamica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ControleDeFluxoTest {

    private ControleDeFluxo controle;

    @BeforeEach
    void setUp() {
        controle = new ControleDeFluxo();
    }

    @Test
    @DisplayName("Deve processar arquivo e retornar lista de hashes")
    void deveProcessarArquivoRetornarHashes(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("banana maçã\n");
            writer.write("carro\n");
        }

        ListaDinamica<String> hashes = controle.processar(arquivo.getAbsolutePath());

        assertEquals(2, hashes.tamanho());
        assertNotNull(hashes.obter(0));
        assertNotNull(hashes.obter(1));
    }

    @Test
    @DisplayName("Deve retornar hash de 40 caracteres")
    void deveRetornarHash40Caracteres(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("teste\n");
        }

        ListaDinamica<String> hashes = controle.processar(arquivo.getAbsolutePath());

        assertEquals(40, hashes.obter(0).length());
    }

    @Test
    @DisplayName("Deve retornar lista vazia para arquivo inexistente")
    void deveRetornarListaVaziaArquivoInexistente() {
        ListaDinamica<String> hashes = controle.processar("arquivo_inexistente.txt");

        assertTrue(hashes.estaVazia());
    }

    @Test
    @DisplayName("Deve processar arquivo de uma linha")
    void deveProcessarArquivoUmaLinha(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("palavra1 palavra2\n");
        }

        ListaDinamica<String> hashes = controle.processar(arquivo.getAbsolutePath());

        assertEquals(1, hashes.tamanho());
    }

    @Test
    @DisplayName("Deve processar arquivo com linhas em ordem")
    void deveProcessarArquivoOrdemInversa(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("primeira linha\n");
            writer.write("segunda linha\n");
            writer.write("terceira linha\n");
        }

        ListaDinamica<String> hashes = controle.processar(arquivo.getAbsolutePath());

        assertEquals(3, hashes.tamanho());
    }

    @Test
    @DisplayName("Deve gerar hashes consistentes para mesma entrada")
    void deveGerarHashesConsistentes(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("teste\n");
        }

        ListaDinamica<String> hashes1 = controle.processar(arquivo.getAbsolutePath());

        File arquivo2 = tempDir.resolve("teste2.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo2)) {
            writer.write("teste\n");
        }

        ListaDinamica<String> hashes2 = controle.processar(arquivo2.getAbsolutePath());

        assertEquals(hashes1.obter(0), hashes2.obter(0));
    }

    @Test
    @DisplayName("Deve ignorar linhas vazias no arquivo")
    void deveIgnorarLinhasVazias(@TempDir Path tempDir) throws IOException {
        File arquivo = tempDir.resolve("teste.txt").toFile();
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write("linha1\n");
            writer.write("\n");
            writer.write("linha2\n");
        }

        ListaDinamica<String> hashes = controle.processar(arquivo.getAbsolutePath());

        assertEquals(2, hashes.tamanho());
    }
}