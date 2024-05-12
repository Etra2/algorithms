package com.algorithms.graph;


import java.util.*;

public class GraphBFS {

    //liczba wirzchołków
    private int V;
    //lista sasiedztwa
    private LinkedList<Integer>[] adjList;

    //konstruktor - inicjalizuje graf z określona liczba wierzchołków
    public GraphBFS(int vertices) {
        V = vertices;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    //metoda dodająca krawędź między wierzchołkami u i v
    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    //metoda wykonująca agorytm BFS, rozpoczynając od wierzchołka V
    public void BFS(int v) {
        //tablica z odwiedzonymi wierzchołkami
        boolean[] visited = new boolean[V];
        //kolejka przechowująca wierzchołki do odwiedzenia
        Queue<Integer> queue = new LinkedList<>();
        //oznaczanie wierzchołka jako odwiedzony
        visited[v] = true;
        //dodanie wierzchołka do kolejki
        queue.add(v);

        while (!queue.isEmpty()) {
            //pobieranie wierzchołka z kolejki
            int currentVertex = queue.poll();
            //wyświetlanie odwiedzonego wierzchołka
            System.out.println(currentVertex + " ");

            //przetwarzanie sąsiadów bieżącego wierzchołka
            for (int neighbor : adjList[currentVertex]) {
                if (!visited[neighbor]) {
                    //oznaczanie sąsiada jako odwiedzony
                    visited[neighbor] = true;
                    //dodanie sąsiada do kolejki
                    queue.add(neighbor);
                }
            }
        }
    }
}
