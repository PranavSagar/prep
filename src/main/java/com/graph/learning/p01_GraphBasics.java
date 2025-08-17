package com.graph.learning;

import java.util.*;

public class p01_GraphBasics {
    private int vertices;
    private List<List<Integer>> adjList;

    public p01_GraphBasics(int v) {
        vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Undirected graph; remove if directed
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int node : adjList.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        p01_GraphBasics g = new p01_GraphBasics(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.printGraph();
    }
}