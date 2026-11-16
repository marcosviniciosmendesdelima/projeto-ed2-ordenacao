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
- Ao ordenar, exibe os dados de entrada e de saída; para vetores com mais de 100 elementos, mostra os 100 primeiros e informa o tamanho total.
- Lê números inteiros de todas as linhas de `dados.txt`, localizado no diretório de onde o programa é executado. Os valores podem ser separados por vírgulas ou espaços.
- Se `dados.txt` não existir, avisa e cria um vetor aleatório de 1.000 elementos. Erros de leitura ou valores inválidos no arquivo são informados como erros, não tratados como ausência do arquivo.
- Compara os cinco algoritmos com as mesmas entradas aleatórias para os tamanhos `n`, `n²`, `n³` e `n¹⁰`. O valor-base definido no programa é `n = 2`, portanto os tamanhos usados são 2, 4, 8 e 1.024 elementos. A opção 4 mostra a média de cinco medições após três aquecimentos, em milissegundos, e verifica se cada resultado está ordenado.

Os tempos da opção 4 são medições práticas, sujeitas a variações de máquina e execução; não são estimativas da IA. Para cumprir a simulação pedida, a tabela abaixo é uma estimativa teórica elaborada com **GitHub Copilot (Copilot SDK no VS Code)**. O modelo usa o número de operações dominantes previsto pela complexidade assintótica e considera, apenas para comparação, 1 ns por operação dominante. Não representa o tempo real da JVM ou de um computador específico e não substitui a medição da opção 4.

### Simulação teórica estimada pela IA

Prompt usado: “Para BubbleSort, InsertionSort, MergeSort, QuickSort e SelectionSort, estime o número de operações dominantes para entradas de tamanho n, n², n³ e n¹⁰, usando n = 2. Com base em 1 ns por operação dominante, monte uma tabela comparativa de tempo em milissegundos. Considere O(n²) para BubbleSort, InsertionSort e SelectionSort e O(n log₂ n) médio para MergeSort e QuickSort. Explique que são estimativas teóricas e não medições de uma máquina.”

Estimativas resultantes do modelo simplificado (n = 2):

| Algoritmo | n = 2 (ms) | n² = 4 (ms) | n³ = 8 (ms) | n¹⁰ = 1.024 (ms) |
|---|---:|---:|---:|---:|
| BubbleSort | 0,000004 | 0,000016 | 0,000064 | 1,048576 |
| InsertionSort | 0,000004 | 0,000016 | 0,000064 | 1,048576 |
| MergeSort | 0,000002 | 0,000008 | 0,000024 | 0,010240 |
| QuickSort (médio) | 0,000002 | 0,000008 | 0,000024 | 0,010240 |
| SelectionSort | 0,000004 | 0,000016 | 0,000064 | 1,048576 |

O modelo conta n² operações para os algoritmos quadráticos e n log₂(n) para os algoritmos O(n log n); por isso os valores são aproximações de ordem de grandeza. Em particular, QuickSort tem pior caso O(n²), e seus valores na tabela representam o caso médio. Para obter tempos práticos na máquina usada na apresentação, execute **4. Executar tabela comparativa**.

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
