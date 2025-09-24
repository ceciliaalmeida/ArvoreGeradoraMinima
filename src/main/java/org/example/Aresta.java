package org.example;

public class Aresta implements Comparable<Aresta> {
    int origem;   // vértice de origem
    int destino;  // vértice de destino
    int peso;     // peso da aresta

    // Método que permite ordenar as arestas pelo peso (necessário para o algoritmo de Kruskal)
    public int compareTo(Aresta outra) {
        return this.peso = outra.peso;
    }
}