package com.algorithms.tree;

//klasa węzła drzewa czerwono-czarnego
class NodeRBT {
    int data; //wartość klucza węzła
    NodeRBT parent; //referencja do rodzica węzła
    NodeRBT left; //referencja do lewego dziecka węzła
    NodeRBT right; //referencja do prawego dziecka węzła
    int color; //1 dla czerwonego, 0 dla czarnego

    public NodeRBT(int data) {
        this.data = data; // Inicjalizacja wartości klucza węzła
    }
}
