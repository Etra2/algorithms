package com.algorithms.graph;

import java.util.*;

//klasa implementująca algorytm Dijkstry
public class Dijkstry {
    private int V; //liczba wierzchołków
    private List<List<NodeDijkstra>> adj; //lista sąsiedztwa
    private PriorityQueue<NodeDijkstra> prioQueue; //kolejka priorytetowa dla wierzchołków do przetworzenia
    private int[] distance; //tablica odległości od źródła
    private Set<Integer> settledVertex; //zbiór wierzchołków już przetworzonych

    public Dijkstry(int V) {
        this.V = V;
        distance = new int[V];
        settledVertex = new HashSet<>();
        prioQueue = new PriorityQueue<>(V, new NodeDijkstra());
    }

    public int[] getDistance() {
        return distance;
    }

    //metoda wykonująca algorytm Dijkstry
    public void dijkstra(List<List<NodeDijkstra>> adj, int src) {
        this.adj = adj;

        //inicjalizacja tablicy odległości
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //dodanie źródła do kolejki priorytetowej
        prioQueue.add(new NodeDijkstra(src, 0));
        distance[src] = 0;

        //główna pętla algorytmu Dijkstry
        while (!prioQueue.isEmpty()) {
            int u = prioQueue.remove().node;
            settledVertex.add(u);
            e_Neidhbours(u);
        }
    }

    //metoda do przetwarzania sąsiadów danego wierzchołka
    private void e_Neidhbours(int u) {
        int edgeDistance;
        int newDistance;

        //iteracja po sąsiadach wierzchołka u
        for (NodeDijkstra v : adj.get(u)) {
            //jeśli wierzchołek nie został jeszcze przetworzony
            if (!settledVertex.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = distance[u] + edgeDistance;

                //aktualizacja odległości, jeśli znaleziono krótszą ścieżkę
                if (newDistance < distance[v.node]) {
                    distance[v.node] = newDistance;
                    prioQueue.add(new NodeDijkstra(v.node, newDistance));
                }
            }
        }
    }
}