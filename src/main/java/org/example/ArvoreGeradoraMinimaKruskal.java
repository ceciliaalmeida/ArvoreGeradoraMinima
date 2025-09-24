package org.example;

import java.util.Arrays;

public class ArvoreGeradoraMinimaKruskal {

        int V; // número de vértices
        int E; // número de arestas
        Aresta[] arestas; // lista de arestas do grafo

        // Construtor
        ArvoreGeradoraMinimaKruskal(int vertices, int arestasTotais) {
        V = vertices;
        E = arestasTotais;
        arestas = new Aresta[E];
        for (int i = 0; i < arestasTotais; i++) {
            arestas[i] = new Aresta();
        }
    }

        // Função "find" do Union-Find: encontra o conjunto de um elemento
        int encontrar(Subconjunto subconjuntos[], int i) {
        if (subconjuntos[i].pai != i) {
            subconjuntos[i].pai = encontrar(subconjuntos, subconjuntos[i].pai);
        }
        return subconjuntos[i].pai;
    }

        // Função "union" do Union-Find: une dois conjuntos diferentes
        void unir(Subconjunto subconjuntos[], int x, int y) {
        int raizX = encontrar(subconjuntos, x);
        int raizY = encontrar(subconjuntos, y);

        // União por rank (balanceamento)
        if (subconjuntos[raizX].rank < subconjuntos[raizY].rank) {
            subconjuntos[raizX].pai = raizY;
        } else if (subconjuntos[raizX].rank > subconjuntos[raizY].rank) {
            subconjuntos[raizY].pai = raizX;
        } else {
            subconjuntos[raizY].pai = raizX;
            subconjuntos[raizX].rank++;
        }
    }

        // Função principal que constrói a Árvore Geradora Mínima usando Kruskal
        void kruskalAgm() {
        Aresta[] resultado = new Aresta[V]; // Vai guardar as arestas da AGM
        int e = 0; // contador de arestas incluídas na AGM
        int i = 0; // índice para percorrer todas as arestas

        for (i = 0; i < V; ++i) {
            resultado[i] = new Aresta();
        }

        // Passo 1: ordenar todas as arestas pelo peso
        Arrays.sort(arestas);

        // Criar V subconjuntos com apenas 1 elemento cada (cada vértice é seu próprio conjunto)
        Subconjunto[] subconjuntos = new Subconjunto[V];
        for (i = 0; i < V; ++i) {
            subconjuntos[i] = new Subconjunto();
            subconjuntos[i].pai = i;
            subconjuntos[i].rank = 0;
        }

        i = 0; // reiniciamos para começar a analisar as arestas

        // Vamos incluir arestas até que tenhamos V-1 arestas na AGM
        while (e < V - 1 && i < E) {
            // Pega a próxima aresta da lista ordenada
            Aresta proximaAresta = arestas[i++];

            int x = encontrar(subconjuntos, proximaAresta.origem);
            int y = encontrar(subconjuntos, proximaAresta.destino);

            // Se incluir essa aresta NÃO formar ciclo, incluímos na AGM
            if (x != y) {
                resultado[e++] = proximaAresta;
                unir(subconjuntos, x, y);
            }
            // Senão, descartamos a aresta (pois formaria ciclo)
        }

        // Imprimir o resultado final
        System.out.println("Arestas da Árvore Geradora Mínima (Kruskal):");
        int custoTotal = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(resultado[i].origem + " - " + resultado[i].destino +
                    " \tPeso: " + resultado[i].peso);
            custoTotal += resultado[i].peso;
        }
        System.out.println("Custo total da AGM: " + custoTotal);
    }
}
