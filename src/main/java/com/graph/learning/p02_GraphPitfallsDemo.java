package com.graph.learning;

import java.util.*;

// Edge class: har neighbour ke sath weight store karne ke liye
class Edge {
    int to, w;
    Edge(int to, int w) { this.to = to; this.w = w; }

    @Override
    public String toString() {
        return "(" + to + ", w=" + w + ")";
    }

    // equals & hashCode => duplicates avoid karne ke liye (parallel edge)
//    Jab bhi main HashSet ya HashMap me apne custom object use karunga, mujhe equals() override karna hoga taaki
//    logical equality check ho sake, aur uske sath hashCode() bhi override karna hoga taaki same objects same bucket me aayein.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge e = (Edge) o;
        return to == e.to && w == e.w;
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, w);
    }
}

public class p02_GraphPitfallsDemo {
    private final int V; // number of vertices (0..V-1)
    private final boolean directed;
    private final List<Set<Edge>> adj; // List of Sets -> no duplicate edges

    public p02_GraphPitfallsDemo(int vertices, boolean directed) {
        this.V = vertices;
        this.directed = directed;
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new HashSet<>());
    }

    /** 1-based input handle karta hai, self-loop skip karta hai */
    public void addEdge1Based(int u1, int v1, int w) {
        int u = u1 - 1; // convert 1-based -> 0-based
        int v = v1 - 1;

        // out of bounds ya self-loop to ignore
        if (u < 0 || v < 0 || u >= V || v >= V || u == v) return;

        adj.get(u).add(new Edge(v, w));
        if (!directed) adj.get(v).add(new Edge(u, w));
    }

    public void printAdjList() {
        System.out.println("Adjacency List" + (directed ? " (Directed)" : " (Undirected)") + ":");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            List<Edge> sorted = new ArrayList<>(adj.get(i));
            sorted.sort(Comparator.comparingInt(e -> e.to));
            for (Edge e : sorted) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Matrix version sirf demo ke liye (dense graph me hi use karna) */
    public int[][] buildAdjMatrixSmall() {
        int[][] mat = new int[V][V];
        for (int u = 0; u < V; u++) {
            for (Edge e : adj.get(u)) {
                mat[u][e.to] = e.w;
            }
        }
        return mat;
    }

    public static void printMatrix(int[][] m) {
        System.out.println("Adjacency Matrix (0 = no edge):");
        for (int[] row : m) {
            for (int val : row) System.out.printf("%3d ", val);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // === Demo 1: Undirected graph with 4 vertices ===
        p02_GraphPitfallsDemo gUndir = new p02_GraphPitfallsDemo(4, false);

        // Input edges (1-based): (u, v, w)
        int[][] edges = {
                {1, 1, 10}, // self-loop -> ignore
                {1, 2, 4},  // valid
                {1, 2, 4},  // duplicate -> ignore
                {1, 3, 6},
                {2, 3, 5},
                {3, 4, 7},
                {4, 2, 8}
        };

        for (int[] e : edges) gUndir.addEdge1Based(e[0], e[1], e[2]);

        gUndir.printAdjList();
        printMatrix(gUndir.buildAdjMatrixSmall());

        // === Demo 2: Directed graph with same edges ===
        p02_GraphPitfallsDemo gDir = new p02_GraphPitfallsDemo(4, true);
        for (int[] e : edges) gDir.addEdge1Based(e[0], e[1], e[2]);
        gDir.printAdjList();
        printMatrix(gDir.buildAdjMatrixSmall());
    }
}