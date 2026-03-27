# Autenticador Digital

**Disciplina:** Estruturas de Dados  
**Linguagem:** Java

---

## Descrição do Projeto

Autenticador Digital é um sistema que lê arquivos de texto (.TXT), processa cada linha utilizando estruturas de dados personalizadas (Lista Dinâmica, Árvore AVL e Pilha) e gera um código de autenticação único via hash SHA-1 para cada linha do documento.

Este projeto foi desenvolvido como trabalho vivencial para a disciplina de Estruturas de Dados, com o objetivo de implementar manualmente as principais estruturas de dados sem utilizar bibliotecas prontas do Java.

---

## Estruturas de Dados Implementadas

### Lista Dinâmica (`ListaDinamica<T>`)
Implementação de lista encadeada simples com generics e inner class.
- **Inner class:** `No<T>`
- **Métodos:** `adiciona()`, `remove()`, `obter()`, `tamanho()`, `estaVazia()`, `iterator()`, `toString()`
- Não utiliza `java.util.LinkedList`

### Árvore AVL (`ArvoreAVL`)
Árvore binária de busca balanceada com rotação automática e inner class.
- **Inner class:** `No`
- **Métodos:** `estaVazia()`, `getRaiz()`, `setRaiz()`, `inserir()`, `imprimirInOrder()`, `gerarHashRaiz()`, `calcularBaixoParaCima()`
- **Balanceamento:** Fator de balanceamento com rotações LL, RR, LR e RL
- **Comparação:** Lexicográfica com `compareToIgnoreCase()`
- **Inserção:** Ignora palavras duplicadas
- **Hash:** Cálculo bottom-up com lógica específica para cada caso

### Pilha (`Pilha`)
Implementação de pilha para armazenar árvores AVL com inner class.
- **Inner class:** `No`
- **Métodos:** `empilhar()`, `desempilhar()`, `estaVazia()`, `verTopo()`, `tamanho()`
- Não utiliza `java.util.Stack`

### Gerador de Hash (`GeradorHashSHA1`)
Utilitário para geração de hash SHA-1.
- **Algoritmo:** SHA-1 via `java.security.MessageDigest`
- **Saída:** String hexadecimal de 40 caracteres (lowercase)

### Controle de Fluxo (`ControleDeFluxo`)
Orquestra o fluxo principal da aplicação.
- **Método principal:** `generateAuthCodes(String path)` → retorna `ListaDinamica<String>` com os hashes

---

## Fluxo de Execução

```
1. Ler arquivo .TXT (mínimo 30 linhas)
   ↓
2. Para cada linha:
   a) Dividir em palavras (split por espaço)
   b) Inserir palavras na Lista Dinâmica (ordem original)
   c) Percorrer lista em ordem REVERSA
   d) Inserir cada palavra na Árvore AVL
   e) Empilhar a árvore na Pilha
   ↓
3. Desempilhar árvores uma a uma
   ↓
4. Para cada árvore:
   a) Calcular hash SHA-1 bottom-up (dos nós folha até a raiz)
   b) Imprimir hash da raiz
   ↓
5. Saída: Um hash por linha, separado por \n
```

---

## Lógica de Geração do Hash

O hash de cada nó é calculado recursivamente (bottom-up):

| Caso | Fórmula |
|------|---------|
| Folha (sem filhos) | `SHA-1(palavra)` |
| Apenas filho esquerdo | `SHA-1(hashEsq + hashNo)` |
| Apenas filho direito | `SHA-1(hashNo + hashDir)` |
| Dois filhos | `SHA-1(hashEsq + hashDir + hashNo)` |

O hash final de cada linha é o hash armazenado no **nó raiz** da árvore AVL.

---

## Como Executar

### Compilação

```bash
javac -d out src/**/*.java src/*.java
```

### Execução

```bash
java -cp out app.Aplicativo
```

O programa espera um arquivo `AutenticadorDigital.txt` no diretório raiz do projeto.

---

## Validação

O sistema foi validado com o seguinte caso de teste:

- **Entrada:** `"Eu amo muito essa disciplina"` (sem exclamação)
- **Hash esperado:** `f44040deec0de6e3100f7ff772bb7a25646e71ed`

---

## Estrutura de Arquivos

```
AutenticadorDigital/
├── src/
│   ├── app/
│   │   └── Aplicativo.java
│   ├── estruturas/
│   │   ├── ArvoreAVL.java      (inclui inner class No)
│   │   ├── ListaDinamica.java (inclui inner class No<T> e ListaIterator)
│   │   └── Pilha.java         (inclui inner class No)
│   ├── servico/
│   │   ├── ControleDeFluxo.java
│   │   └── LeitorDeDocumentos.java
│   └── util/
│       └── GeradorHashSHA1.java
├── AutenticadorDigital.txt
└── README.md
```

---

## Autor

Projeto desenvolvido em grupo como trabalho da disciplina de Estruturas de Dados.
