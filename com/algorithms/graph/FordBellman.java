package com.algorithms.graph;

import java.util.*;

//klasa reprezentująca algorytm Forda-Bellmana
public class FordBellman {
    int V; //liczba wierzchołków w grafie
    List<EdgeFB> edgeFB; //lista krawędzi

    //konstruktor klasy FordBellman
    public FordBellman(int v) {
        V = v;
        edgeFB = new ArrayList<>();
    }

    //metoda dodająca krawędź do grafu
    public void addEdge(int source, int destination, int weight) {
        edgeFB.add(new EdgeFB(source, destination, weight));
    }

    //metoda implementująca algorytm Forda-Bellmana
    public void bellmanFord(int source) {
        int[] dist = new int[V];

        //inicjalizacja odległości od źródła do pozostałych wierzchołków jako nieskończoność
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        //relaksacja wszystkich krawędzi V-1 razy
        for (int i = 1; i < V; ++i) {
            for (EdgeFB edge : edgeFB) {
                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        //sprawdzenie czy istnieją cykle o ujemnej wadze
        for (EdgeFB edge : edgeFB) {
            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graf zawiera cykl o ujemnej wadze");
                return;
            }
        }

        //wyświetlanie tablicy odległości
        System.out.println("Wierzchołek | Odległość od źródła");
        for (int i = 0; i < V; ++i) {
            System.out.println(i + "\t\t\t\t" + dist[i]);
        }
    }
}
