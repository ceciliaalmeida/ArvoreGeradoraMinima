package org.example;
import java.util.*;

public class PrimFibraOptica {

    private static final int INF = Integer.MAX_VALUE;

//  Procura o vértice com menor chave que ainda não foi incluído na AGM
    private static int menorChave(int[] key, boolean[] mstSet, int V) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Função que implementa o algoritmo de Prim
    public static void primAGM(int[][] graph, int V) {
        int[] parent = new int[V];   // Armazena a AGM
        int[] chave = new int[V];      // Menores pesos até cada vértice
        boolean[] agmSet = new boolean[V]; // Se o vértice já foi incluído

        // Inicializa todas as chaves como infinito
        Arrays.fill(chave, INF);

        // Começa pelo vértice 0 (CIDADE A)
        chave[0] = 0;
        parent[0] = -1; // Primeiro vértice é a raiz da AGM

        for (int count = 0; count < V - 1; count++) {
            // Escolhe o vértice u de menor chave ainda não incluído na AGM
            int u = menorChave(chave, agmSet, V);
            agmSet[u] = true;

            // Atualiza valores dos vértices adjacentes ao vértice u
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !agmSet[v] && graph[u][v] < chave[v]) {
                    parent[v] = u;
                    chave[v] = graph[u][v];
                }
            }
        }

        System.out.println("Arestas da AGM (Prim):");
        int total = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "  peso: " + graph[i][parent[i]] + "km") ;
            total += graph[i][parent[i]];
        }
        System.out.println("Custo total = " + total + "Km");
    }
}

