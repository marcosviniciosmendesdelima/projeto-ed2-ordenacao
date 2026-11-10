# Projeto Prático: Algoritmos de Ordenação

Trabalho prático da disciplina de **Estrutura de Dados II**, do curso de Ciência da Computação. O projeto implementa algoritmos de ordenação em Java e permite executá-los sobre dados de entrada e comparar seus tempos de execução.

## Equipe

- Marcos Vinícios Mendes de Lima
- Augusto Luiz Lima Dantas
- Victor Manoel da Silva
- Ismar Ferreira de Macêdo Neto
- Pedro Henrique Matos de Medeiros

## Estrutura do projeto

```text
meu-projeto/
├── README.md
└── ed2/
    └── projeto/
        ├── Main.java
        └── algoritmosordenacao/
            ├── IAlgoritmoOrdenacao.java
            ├── BubbleSort.java
            ├── InsertionSort.java
            ├── MergeSort.java
            ├── QuickSort.java
            ├── SelectionSort.java
            └── Utils.java
```

`Main` pertence ao pacote `ed2.projeto`. A interface e as classes de ordenação pertencem ao pacote `ed2.projeto.algoritmosordenacao`.

## O que o programa faz

- Permite selecionar BubbleSort, InsertionSort, MergeSort, QuickSort ou SelectionSort.
- Exibe o vetor de entrada e a saída ordenada; para vetores com mais de 100 elementos, mostra os 100 primeiros e informa o tamanho total.
- Lê números inteiros de todas as linhas de `dados.txt`, localizado no diretório de onde o programa é executado. Os valores podem ser separados por vírgulas ou espaços.
- Se `dados.txt` não existir, avisa e cria um vetor aleatório de 1.000 elementos. Erros de leitura ou valores inválidos no arquivo são informados como erros, não tratados como ausência do arquivo.
- Compara os cinco algoritmos com vetores aleatórios de tamanhos `n`, `n²`, `n³` e `n¹⁰`. O valor-base definido no programa é `n = 2`, portanto os tamanhos usados são 2, 4, 8 e 1.024 elementos. A tabela mostra o tempo medido em milissegundos para cada algoritmo e tamanho.

Os tempos são medidos uma vez por algoritmo e tamanho. São resultados práticos sujeitos a variações de máquina e execução, não uma análise estatística. As complexidades teóricas são:

### Exemplo de tabela comparativa

Uma execução de referência, com vetores aleatórios e `n = 2`, produziu os tempos abaixo. Use-os como estimativas ilustrativas: os tamanhos menores são afetados pelo custo de inicialização e pela resolução do relógio, e os resultados variam conforme a máquina.

| Algoritmo | n = 2 (ms) | n² = 4 (ms) | n³ = 8 (ms) | n¹⁰ = 1.024 (ms) |
|---|---:|---:|---:|---:|
| BubbleSort | 0,003 | 0,002 | 0,002 | 4,892 |
| InsertionSort | 0,001 | 0,001 | 0,002 | 2,448 |
| MergeSort | 0,010 | 0,003 | 0,003 | 1,179 |
| QuickSort | 0,010 | 0,004 | 0,003 | 0,393 |
| SelectionSort | 0,001 | 0,001 | 0,002 | 3,010 |

Os valores são de uma única execução e não devem ser interpretados como um ranking definitivo. Execute a opção **4. Executar tabela comparativa** para medir novamente no seu ambiente.

| Algoritmo | Complexidade esperada |
|---|---|
| BubbleSort | O(n²); melhor caso O(n) |
| InsertionSort | O(n²); melhor caso O(n) |
| SelectionSort | O(n²) |
| MergeSort | O(n log n) |
| QuickSort | O(n log n) em média; O(n²) no pior caso |

## Como compilar e executar

É necessário ter o **JDK 11 ou superior** instalado. Execute os comandos a partir da raiz de `meu-projeto`:

```sh
javac -encoding ISO-8859-1 -d out ed2/projeto/Main.java ed2/projeto/algoritmosordenacao/*.java
java -cp out ed2.projeto.Main
```

A opção `-encoding ISO-8859-1` permite compilar `QuickSort.java` e `Utils.java`, que contêm caracteres nessa codificação.

## Arquivo de entrada opcional

Crie `dados.txt` na raiz do projeto, por exemplo:

```text
45, 12, 89
3, 22, 7
```

O programa lê todas as linhas, com números separados por vírgulas ou espaços em branco.
