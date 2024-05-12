package com.algorithms.graph;



//klasa reprezentująca krawędź grafu.
public class EdgeBFS implements Comparable<EdgeBFS> {
    int source, destination, weight;

    public EdgeBFS(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    //porównujemy krawędzie na podstawie ich wagi.
    @Override
    public int compareTo(EdgeBFS compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
