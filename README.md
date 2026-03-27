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
Implementação de lista encadeada simples com generics.
- **Métodos:** `add()`, `remove()`, `get()`, `size()`, `isEmpty()`, `iterator()`, `forEachReverso()`
- Não utiliza `java.util.LinkedList`

### Árvore AVL (`Arvore`)
Árvore binária de busca balanceada com rotação automática.
- **Balanceamento:** Fator de balanceamento com rotações LL, RR, LR e RL
- **Comparação:** Lexicográfica com `compareToIgnoreCase()`
- **Inserção:** Ignora palavras duplicadas

### Pilha (`PilhaArvore`)
Implementação de pilha para armazenar árvores AVL.
- **Métodos:** `push()`, `pop()`, `peek()`, `estaVazia()`, `tamanho()`
- Não utiliza `java.util.Stack`

### Gerador de Hash (`GeradorHashSHA1`)
Utilitário para geração de hash SHA-1.
- **Algoritmo:** SHA-1 via `java.security.MessageDigest`
- **Saída:** String hexadecimal de 40 caracteres (lowercase)

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
java -cp out app.Teste
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
│   │   ├── Aplicativo.java
│   │   └── Teste.java
│   ├── estruturas/
│   │   ├── Arvore.java
│   │   ├── ListaDinamica.java
│   │   ├── PilhaArvore.java
│   │   ├── NoArvore.java
│   │   ├── NoLista.java
│   │   └── NoPilha.java
│   ├── servico/
│   │   ├── ControleDeFluxo.java
│   │   └── LeitorDeDocumentos.java
│   └── util/
│       └── GeradorHashSHA1.java
├── AutenticadorDigital.txt
├── instructions.md
└── README.md
```

---

## Autor

Projeto desenvolvido como trabalho da disciplina de Estruturas de Dados.
