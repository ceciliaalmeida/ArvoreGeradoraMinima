package org.example;
import java.util.*;

import static org.example.PrimSimples.prim;

public class Main {
    public static void main(String[] args) {
        // Programa principal (main)
        System.out.printf("Algoritmo de Prim (AGM) ");

        /*
         * Exemplo de grafo representado em matriz de adjacência:
         *
         *        (0)
         *       /   \
         *     2      6
         *    /        \
         *  (1)---3---(2)
         *    \       /
         *     5     7
         *      \   /
         *       (4)
         *        |
         *        9
         *        |
         *       (3)
         *
         */
        int grafoPrim[][] = new int[][] {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        ArvoreGeradoraMinimaPrim agm = new ArvoreGeradoraMinimaPrim();
        agm.prim(grafoPrim);

        System.out.println("PRIM SIMPLES");
        // Exemplo de grafo em matriz de adjacência
        int grafoPrimSimples[][] = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        prim(grafoPrimSimples);

        System.out.println("Algoritmo de Kruskal (AGM): ");


        /*
         * Exemplo de grafo:
         * V = 4 vértices
         * E = 5 arestas
         *
         * Grafo:
         * 0 --(10)-- 1
         * 0 --(6) -- 2
         * 0 --(5) -- 3
         * 1 --(15)- 3
         * 2 --(4) -- 3
         */

        int V = 4; // número de vértices
        int E = 5; // número de arestas
        ArvoreGeradoraMinimaKruskal grafoKruskal = new ArvoreGeradoraMinimaKruskal(V, E);

        // Definição das arestas do grafo
        grafoKruskal.arestas[0].origem = 0;
        grafoKruskal.arestas[0].destino = 1;
        grafoKruskal.arestas[0].peso = 10;

        grafoKruskal.arestas[1].origem = 0;
        grafoKruskal.arestas[1].destino = 2;
        grafoKruskal.arestas[1].peso = 6;

        grafoKruskal.arestas[2].origem = 0;
        grafoKruskal.arestas[2].destino = 3;
        grafoKruskal.arestas[2].peso = 5;

        grafoKruskal.arestas[3].origem = 1;
        grafoKruskal.arestas[3].destino = 3;
        grafoKruskal.arestas[3].peso = 15;

        grafoKruskal.arestas[4].origem = 2;
        grafoKruskal.arestas[4].destino = 3;
        grafoKruskal.arestas[4].peso = 4;

        // Executa o algoritmo de Kruskal
        grafoKruskal.kruskalAgm();

        System.out.println("Kruskall Simples: ");

        int Variavel = 4, Arestas = 5;
        KruskallSimples grafoKruskalSimples = new KruskallSimples(Variavel, Arestas);

        // Definição das arestas
        grafoKruskalSimples.arestas[0].origem = 0; grafoKruskalSimples.arestas[0].destino = 1; grafoKruskalSimples.arestas[0].peso = 10;
        grafoKruskalSimples.arestas[1].origem = 0; grafoKruskalSimples.arestas[1].destino = 2; grafoKruskalSimples.arestas[1].peso = 6;
        grafoKruskalSimples.arestas[2].origem = 0; grafoKruskalSimples.arestas[2].destino = 3; grafoKruskalSimples.arestas[2].peso = 5;
        grafoKruskalSimples.arestas[3].origem = 1; grafoKruskalSimples.arestas[3].destino = 3; grafoKruskalSimples.arestas[3].peso = 15;
        grafoKruskalSimples.arestas[4].origem = 2; grafoKruskalSimples.arestas[4].destino = 3; grafoKruskalSimples.arestas[4].peso = 4;

        grafoKruskalSimples.kruskal();
    }

}
