package com.algorithms.graph;

import java.util.LinkedList;

public class GraphDFS {
    //liczba wierzchołków
    private int V;
    //lista sąsiedztwa
    private LinkedList<Integer>[] adjList;

    //konstruktor - inicjalizuje graf z określona liczbą wierzchołków

    public GraphDFS(int vertices) {
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

    //metoda wykonująca agorytm DFS, rozpoczynając od wierzchołka v
    public void DFS(int v) {
        //tablica z odwiedzonymi wierzchołkami
        boolean[] visited = new boolean[V];
        //wywołanie rekurencyjnej metody DFS
        DSFUtil(v, visited);
    }

    //metoda pomocnicza dla DFS
    private void DSFUtil(int v, boolean[] visited) {
        //oznaczenie wierzchołka jako odwiedzony
        visited[v] = true;
        //wyświetlanie odwiedzonego wierzchołka
        System.out.println(v + " ");

        //przetwarzanie sąsiadów bieżącego wierzchołka
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                // Wywołanie rekurencyjne dla nieodwiedzonego sąsiada
                DSFUtil(neighbor, visited);
            }
        }
    }
}
