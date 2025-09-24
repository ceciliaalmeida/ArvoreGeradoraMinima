package org.example;

import java.util.Arrays;

public class KruskallSimples {

    int V, E;
    Aresta[] arestas;

    KruskallSimples(int vertices, int arestasTotais) {
        V = vertices;
        E = arestasTotais;
        arestas = new Aresta[E];
        for (int i = 0; i < E; i++) {
            arestas[i] = new Aresta();
        }
    }

    // Função do Union-Find: encontra o conjunto de um elemento
    int encontrar(Subconjunto[] subconjuntos, int i) {
        if (subconjuntos[i].pai != i) {
            subconjuntos[i].pai = encontrar(subconjuntos, subconjuntos[i].pai);
        }
        return subconjuntos[i].pai;
    }

    // União de dois conjuntos
    void unir(Subconjunto[] subconjuntos, int x, int y) {
        int raizX = encontrar(subconjuntos, x);
        int raizY = encontrar(subconjuntos, y);

        if (subconjuntos[raizX].rank < subconjuntos[raizY].rank) {
            subconjuntos[raizX].pai = raizY;
        } else if (subconjuntos[raizX].rank > subconjuntos[raizY].rank) {
            subconjuntos[raizY].pai = raizX;
        } else {
            subconjuntos[raizY].pai = raizX;
            subconjuntos[raizX].rank++;
        }
    }

    // Algoritmo de Kruskal
    void kruskal() {
        Aresta[] resultado = new Aresta[V];
        for (int i = 0; i < V; i++) resultado[i] = new Aresta();

        Arrays.sort(arestas); // ordena as arestas pelo peso

        Subconjunto[] subconjuntos = new Subconjunto[V];
        for (int v = 0; v < V; v++) {
            subconjuntos[v] = new Subconjunto();
            subconjuntos[v].pai = v;
            subconjuntos[v].rank = 0;
        }

        int e = 0, i = 0;
        while (e < V - 1 && i < E) {
            Aresta proxima = arestas[i++];

            int x = encontrar(subconjuntos, proxima.origem);
            int y = encontrar(subconjuntos, proxima.destino);

            if (x != y) {
                resultado[e++] = proxima;
                unir(subconjuntos, x, y);
            }
        }

        // Mostra a árvore resultante
        System.out.println("Árvore Geradora Mínima (Kruskal):");
        int custoTotal = 0;
        for (i = 0; i < e; i++) {
            System.out.println(resultado[i].origem + " - " + resultado[i].destino +
                    " (peso: " + resultado[i].peso + ")");
            custoTotal += resultado[i].peso;
        }
        System.out.println("Custo total = " + custoTotal);
    }
}
