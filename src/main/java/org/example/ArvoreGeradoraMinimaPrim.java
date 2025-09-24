package org.example;
import java.util.*;

public class ArvoreGeradoraMinimaPrim {
        // Número de vértices no grafo
        private static final int V = 5;

        // Função que encontra o vértice com menor chave que ainda não foi incluído na AGM
        int menorChave(int chave[], boolean incluidoNaAGM[]) {
            int min = Integer.MAX_VALUE; // valor máximo como referência
            int indiceMin = -1;

            for (int v = 0; v < V; v++) {
                if (!incluidoNaAGM[v] && chave[v] < min) {
                    min = chave[v];
                    indiceMin = v;
                }
            }
            return indiceMin;
        }

        // Função que imprime as arestas da AGM
        void imprimirAGM(int pai[], int grafo[][]) {
            System.out.println("Arestas da Árvore Geradora Mínima (Prim):");
            int custoTotal = 0;
            for (int i = 1; i < V; i++) {
                System.out.println(pai[i] + " - " + i + "\tPeso: " + grafo[i][pai[i]]);
                custoTotal += grafo[i][pai[i]];
            }
            System.out.println("Custo total da AGM: " + custoTotal);
        }

        // Função principal que constrói a AGM usando Prim
        void prim(int grafo[][]) {
            int pai[] = new int[V];      // Armazena a AGM (quem é o pai de cada vértice)
            int chave[] = new int[V];    // Valores mínimos para escolher a aresta
            boolean incluidoNaAGM[] = new boolean[V]; // Se o vértice já está na AGM

            // Inicializa todas as chaves como infinito
            Arrays.fill(chave, Integer.MAX_VALUE);

            // Começa pelo vértice 0
            chave[0] = 0;   // a chave do primeiro vértice é 0 para ser escolhido primeiro
            pai[0] = -1;    // o primeiro vértice é a raiz (não tem pai)

            // A AGM terá V-1 arestas
            for (int cont = 0; cont < V - 1; cont++) {
                // Escolhe o vértice u com a menor chave ainda não incluído na AGM
                int u = menorChave(chave, incluidoNaAGM);

                // Marca o vértice u como incluído na AGM
                incluidoNaAGM[u] = true;

                // Atualiza as chaves dos vértices adjacentes de u
                for (int v = 0; v < V; v++) {
                    // grafo[u][v] != 0 significa que existe aresta
                    // !incluidoNaAGM[v] garante que o vértice ainda não está na AGM
                    // grafo[u][v] < chave[v] significa que encontramos uma aresta melhor
                    if (grafo[u][v] != 0 && !incluidoNaAGM[v] && grafo[u][v] < chave[v]) {
                        pai[v] = u;
                        chave[v] = grafo[u][v];
                    }
                }
            }

            // Imprime a AGM
            imprimirAGM(pai, grafo);
        }

}
