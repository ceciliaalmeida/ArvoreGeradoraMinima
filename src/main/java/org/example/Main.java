package org.example;

import static org.example.PrimFibraOptica.primAGM;

public class Main {
    public static void main(String[] args) {
        // Grafo do exemplo de distribuição de fibra optica por cidades (matriz de adjacência)
        int V = 5;
        int[][] graph = {
                {0, 4, 2, 0, 0}, // Cidade A
                {4, 0, 5, 10, 0}, // Cidade B
                {2, 5, 0, 3, 7}, // Cidade C
                {0, 10, 3, 0, 1}, // Cidade D
                {0, 0, 7, 1, 0}  // Cidade E
        };
        primAGM(graph, V);
    }
}