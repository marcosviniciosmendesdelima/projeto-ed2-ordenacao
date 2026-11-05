package ed2.projeto;

import ed2.projeto.algoritmosordenacao.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IAlgoritmoOrdenacao[] algoritmos = {
            new BubbleSort(),
            new InsertionSort(),
            new MergeSort(),
            new QuickSort(),
            new SelectionSort()
        };
        IAlgoritmoOrdenacao algoritmoAtivo = algoritmos[0];
        int[] vetorOriginal;

        try {
            vetorOriginal = carregarVetor("dados.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo dados.txt nao encontrado. Usando vetor aleatorio.");
            vetorOriginal = Utils.gerarVetor(1000, 50000);
        } catch (IOException e) {
            System.out.println("Erro ao ler dados.txt: " + e.getMessage());
            scanner.close();
            return;
        } catch (NumberFormatException e) {
            System.out.println("O arquivo dados.txt deve conter apenas numeros inteiros.");
            scanner.close();
            return;
        }

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU ESTRUTURA DE DADOS II ---");
            System.out.println("Algoritmo ativo: " + algoritmoAtivo);
            System.out.println("1. Escolher algoritmo");
            System.out.println("2. Exibir dados de entrada");
            System.out.println("3. Ordenar e exibir dados de saida");
            System.out.println("4. Executar tabela comparativa");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Digite uma opcao numerica.");
                scanner.next();
                continue;
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nEscolha o algoritmo:");
                    for (int i = 0; i < algoritmos.length; i++) {
                        System.out.println((i + 1) + ". " + algoritmos[i]);
                    }
                    System.out.print("Escolha: ");
                    if (scanner.hasNextInt()) {
                        int escolha = scanner.nextInt();
                        if (escolha >= 1 && escolha <= algoritmos.length) {
                            algoritmoAtivo = algoritmos[escolha - 1];
                        } else {
                            System.out.println("Opcao invalida.");
                        }
                    } else {
                        System.out.println("Digite uma opcao numerica.");
                        scanner.next();
                    }
                    break;
                case 2:
                    exibirVetor(vetorOriginal);
                    break;
                case 3:
                    int[] vetorOrdenado = copiarVetor(vetorOriginal);
                    long inicio = System.nanoTime();
                    algoritmoAtivo.ordenarVetor(vetorOrdenado);
                    long tempo = System.nanoTime() - inicio;
                    System.out.printf("Tempo: %.3f ms%n", tempo / 1000000.0);
                    exibirVetor(vetorOrdenado);
                    break;
                case 4:
                    executarTabela(algoritmos);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }

    private static int[] carregarVetor(String nomeArquivo) throws IOException {
        String linha;
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            linha = leitor.readLine();
        }

        if (linha == null || linha.trim().isEmpty()) {
            return new int[0];
        }

        String[] valores = linha.trim().split("[,\\s]+");
        int[] vetor = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            vetor[i] = Integer.parseInt(valores[i]);
        }
        return vetor;
    }

    private static void exibirVetor(int[] vetor) {
        int limite = Math.min(vetor.length, 100);
        System.out.print("Vetor (" + vetor.length + " elementos) = {");
        for (int i = 0; i < limite; i++) {
            System.out.print(vetor[i]);
            if (i < limite - 1) {
                System.out.print(", ");
            }
        }
        if (vetor.length > 100) {
            System.out.print(", ...");
        }
        System.out.println("}");
    }

    private static int[] copiarVetor(int[] vetor) {
        int[] copia = new int[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            copia[i] = vetor[i];
        }
        return copia;
    }

    private static void executarTabela(IAlgoritmoOrdenacao[] algoritmos) {
        int[] tamanhos = {2, 4, 8, 1024};
        int[][] entradas = new int[tamanhos.length][];

        for (int i = 0; i < tamanhos.length; i++) {
            entradas[i] = Utils.gerarVetor(tamanhos[i], 100000);
        }

        System.out.println("\n--- TABELA COMPARATIVA (n = 2) ---");
        System.out.println("Tamanhos: n=2, n^2=4, n^3=8 e n^10=1024");
        System.out.printf("%-18s | %-12s | %-12s | %-12s | %-12s%n",
                "Algoritmo", "n (ms)", "n^2 (ms)", "n^3 (ms)", "n^10 (ms)");

        for (int i = 0; i < algoritmos.length; i++) {
            System.out.printf("%-18s", algoritmos[i]);
            for (int j = 0; j < tamanhos.length; j++) {
                int[] vetor = copiarVetor(entradas[j]);
                long inicio = System.nanoTime();
                algoritmos[i].ordenarVetor(vetor);
                long tempo = System.nanoTime() - inicio;
                System.out.printf(" | %-12.3f", tempo / 1000000.0);
            }
            System.out.println();
        }
    }
}
