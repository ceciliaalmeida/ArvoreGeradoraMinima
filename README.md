# 🌳 Árvore Geradora Mínima com o Algoritmo de Prim

### Universidade Federal de Sergipe - UFS  
**Departamento de Computação - DCOMP**  
**Programa de Pós-Graduação em Ciências da Computação - PROCC**  
**Disciplina:** Projeto e Análise de Algoritmos  
**Professor:** Leonardo Matos  

**Alunos:**  
- Cecília  
- Lizar  
- Marckson Fábio  

---

## 📌 Descrição do Projeto
Este projeto implementa o **Algoritmo de Prim** para encontrar a **Árvore Geradora Mínima (AGM / MST)** de um grafo.  
A aplicação proposta utiliza a AGM para **otimizar a distribuição de fibra óptica entre cidades**, garantindo **o menor custo de cabeamento possível**.

---

## 🎥 Demonstração em Vídeo
Explicação detalhada sobre a problemática e solução com Prim:  
👉 [Assista no YouTube](https://youtu.be/j9xW_13kZ6A)

---

## ⚙️ Instruções de Execução
1. Instale o **Java** (preferencialmente a versão mais recente).  
2. Faça o **download da pasta do projeto** ou clone o repositório:  
   ```bash
   git clone https://github.com/ceciliaalmeida/ArvoreGeradoraMinima.git
3. Compile e execute o projeto dentro da pasta src.
   
O grafo é representado por uma matriz de adjacência.
Exemplo utilizado no projeto:

int[][] graph = {
    {0, 4, 2, 0, 0},   // Cidade A
    {4, 0, 5, 10, 0},  // Cidade B
    {2, 5, 0, 3, 7},   // Cidade C
    {0, 10, 3, 0, 1},  // Cidade D
    {0, 0, 7, 1, 0}    // Cidade E
};

🚀 Saída Esperada

Ao executar o projeto, o algoritmo de Prim encontra a AGM e imprime as arestas escolhidas com seus respectivos pesos:

Arestas da AGM (Prim):
0 - 1  peso: 4km
0 - 2  peso: 2km
2 - 3  peso: 3km
3 - 4  peso: 1km
Custo total = 10Km

Process finished with exit code 0
