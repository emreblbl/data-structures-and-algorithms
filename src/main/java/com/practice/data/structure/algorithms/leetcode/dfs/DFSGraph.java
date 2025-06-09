package com.practice.data.structure.algorithms.leetcode.dfs;

import java.util.*;

public class DFSGraph {
    // Recursive function for DFS traversal
    private static void
    dfsRec(ArrayList<ArrayList<Integer> > adj,
           boolean[] visited, int s, ArrayList<Integer> res)
    {
        visited[s] = true;
        res.add(s);

        // Recursively visit all adjacent vertices that are
        // not visited yet
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                dfsRec(adj, visited, i, res);
            }
        }
    }

    // Main DFS function that initializes the visited array
    // and calls dfsRec
    public static ArrayList<Integer>
    DFS(ArrayList<ArrayList<Integer> > adj)
    {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        dfsRec(adj, visited, 0, res);
        return res;
    }

    // To add an edge in an undirected graph
    public static void
    addEdge(ArrayList<ArrayList<Integer> > adj, int s,
            int t)
    {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void main(String[] args)
    {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj
                = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        int[][] edges= { { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } };
        for (int[] e : edges)
        {
            addEdge(adj, e[0], e[1]);
        }

        // Perform DFS starting from vertex 0
        ArrayList<Integer> res = DFS(adj);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    /*
    Definition of DFS :
            ### Purpose

        DFS is a strategy for systematically exploring every node of a tree or graph.

        ### Core procedure

        1. **Go deep first** – Starting at a chosen root (or any start vertex), follow one branch as far as possible, visiting each vertex on the way down and marking it as “visited.”
        2. **Back-track** – When you reach a dead end (a vertex with no unvisited children/adjacent vertices), step back to the nearest ancestor that still has unvisited neighbours and continue from there.
        3. **Repeat** until every reachable vertex has been visited.

        ### Essential terminology

        | Term | Correct form | Meaning |
        | --- | --- | --- |
        | **Vertex** (plural **vertices**) | *vertex / vertices* | A node in a graph. Vertices are connected to one another by **edges**. |
        | **Adjacent vertices** | *adjacent vertices* | Two vertices directly connected by a single edge. |

        ### Mini-example for context

        Consider a graph with vertices `A, B, C, D, E` and edges `A-B, B-C, C-D, B-E`.

        A DFS starting at `A` could visit the vertices in this sequence:

        `A → B → C → D` (dead end, back-track to `B`) `→ E`.
     */
}
