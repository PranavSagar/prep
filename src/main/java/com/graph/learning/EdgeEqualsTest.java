package com.graph.learning;

import java.util.*;

public class EdgeEqualsTest {
    public static void main(String[] args) {
        Set<Edge> set = new HashSet<>();

        Edge e1 = new Edge(2, 5);
        Edge e2 = new Edge(2, 5); // logically duplicate
        Edge e3 = new Edge(3, 5); // different

        System.out.println("Adding e1:");
        set.add(e1);

        System.out.println("\nAdding e2 (duplicate of e1):");
        set.add(e2);

        System.out.println("\nAdding e3 (different edge):");
        set.add(e3);

        System.out.println("\nFinal set: " + set);
    }
}