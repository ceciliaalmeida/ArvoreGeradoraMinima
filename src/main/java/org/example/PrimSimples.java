package org.example;

import java.util.Arrays;

public class PrimSimples {

    // Número de vértices do grafo
    static final int V = 5;

    // Função que retorna o índice do vértice com menor chave
    static int pegarMenorChave(int chave[], boolean incluidoNaAGM[]) {
        int minimo = Integer.MAX_VALUE;
        int indiceMinimo = -1;

        // Percorre todos os vértices procurando o menor valor de chave
        for (int v = 0; v < V; v++) {
            if (!incluidoNaAGM[v] && chave[v] < minimo) {
                minimo = chave[v];
                indiceMinimo = v;
            }
        }
        return indiceMinimo;
    }

    // Função principal do algoritmo de Prim
    static void prim(int grafo[][]) {
        int pai[] = new int[V]; // guarda o pai de cada vértice na AGM
        int chave[] = new int[V]; // valores mínimos para escolher as arestas
        boolean incluidoNaAGM[] = new boolean[V]; // marca quais vértices já estão na AGM

        // Inicializa todas as chaves como infinito
        Arrays.fill(chave, Integer.MAX_VALUE);

        // O vértice inicial é 0
        chave[0] = 0;
        pai[0] = -1;   // o primeiro vértice é a raiz, por isso não tem pai

        // A AGM terá V-1 arestas
        for (int count = 0; count < V - 1; count++) {
            int u = pegarMenorChave(chave, incluidoNaAGM);
            incluidoNaAGM[u] = true;

            // Atualiza os valores de chave dos vizinhos
            for (int v = 0; v < V; v++) {
                if (grafo[u][v] != 0 && !incluidoNaAGM[v] && grafo[u][v] < chave[v]) {
                    pai[v] = u;
                    chave[v] = grafo[u][v];
                }
            }
        }

        // Mostra a árvore resultante
        System.out.println("Árvore Geradora Mínima (Prim):");
        int custoTotal = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(pai[i] + " - " + i + " (peso: " + grafo[i][pai[i]] + ")");
            custoTotal += grafo[i][pai[i]];
        }
        System.out.println("Custo total = " + custoTotal);
    }
}