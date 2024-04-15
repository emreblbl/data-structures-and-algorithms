package com.practice.data.structure.algorithms.graph;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex("deneme");
        graph.addVertex("deneme2");
        graph.printGraph();

        graph.addEdge("deneme", "deneme2");
        graph.printGraph();

        graph.removeVertex("deneme");
        graph.printGraph();

    }
}
