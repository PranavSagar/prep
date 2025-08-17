package com.graph.learning;

import java.util.*;

/**
 * Simple BFS/DFS on an unweighted UNDIRECTED graph using adjacency list (int -> int).
 * Focus: traversal mechanics + visited usage + disconnected graphs.
 */
public class p03_BFS_DFS {
    private final int V;
    private final List<List<Integer>> adj;

    public p03_BFS_DFS(int vertices) {
        this.V = vertices;
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    // Undirected edge
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // -------- BFS ----------
    public List<Integer> bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        visited[start] = true;          // Q1: isse pehle ya baad me mark karna chahiye? kyun?
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true; // Q2: yahin mark kyun, poll ke baad nahi?
                    q.add(nei);
                }
            }
        }
        return order;
    }

    // -------- DFS (recursive) ----------
    public List<Integer> dfsRecursive(int start) {
        boolean[] visited = new boolean[V];
        List<Integer> order = new ArrayList<>();
        dfsHelper(start, visited, order);
        return order;
    }

    private void dfsHelper(int node, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        order.add(node);

        for (int nei : adj.get(node)) {
            if (!visited[nei]) dfsHelper(nei, visited, order);
        }
    }

    // -------- DFS (iterative using stack) ----------
    public List<Integer> dfsIterative(int start) {
        boolean[] visited = new boolean[V];
        Deque<Integer> st = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        st.push(start);

        while (!st.isEmpty()) {
            int node = st.pop();
            if (visited[node]) continue;   // Q3: yahan continue lagana kyu zaroori?
            visited[node] = true;
            order.add(node);

            // NOTE: stack LIFO hota—neighbors ko reverse add karoge to order badlega.
            // Stable order ke liye sorted neighbors use kar sakte ho.
            for (int nei : adj.get(node)) {
                if (!visited[nei]) st.push(nei);
            }
        }
        return order;
    }

    // -------- Disconnected graphs: Connected Components ----------
    public List<List<Integer>> connectedComponents() {
        boolean[] visited = new boolean[V];
        List<List<Integer>> comps = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                // BFS ya DFS se fill kar sakte ho; yahan BFS kiya hai:
                Queue<Integer> q = new LinkedList<>();
                visited[i] = true;
                q.add(i);

                while (!q.isEmpty()) {
                    int node = q.poll();
                    comp.add(node);
                    for (int nei : adj.get(node)) {
                        if (!visited[nei]) {
                            visited[nei] = true;
                            q.add(nei);
                        }
                    }
                }
                comps.add(comp);
            }
        }
        return comps;
    }

    // -------- Demo --------
    public static void main(String[] args) {
        /*
            Graph:
              0 -- 1
              |  / |
              | /  |
              2 -- 3      4 (isolated)
         */
        p03_BFS_DFS g = new p03_BFS_DFS(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        // node 4 isolated

        System.out.println("BFS(0): " + g.bfs(0));              // e.g., [0, 1, 2, 3]
        System.out.println("DFS-Recursive(0): " + g.dfsRecursive(0));
        System.out.println("DFS-Iterative(0): " + g.dfsIterative(0));
        System.out.println("Connected Components: " + g.connectedComponents()); // e.g., [[0,1,2,3], [4]]
    }
}