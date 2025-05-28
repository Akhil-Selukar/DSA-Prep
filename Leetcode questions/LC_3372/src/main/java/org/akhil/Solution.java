package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // TC -> O(M + N + N^2 + M^2)  => O(N^2 + M^2)
    // SC -> O(M+N)
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int m = edges1.length + 1;      // total nodes = number of edges + 1;
        int n = edges2.length + 1;

        // Build adjacency lists for tree 1     -> O(M + (M-1)) ~ O(M)
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < m; i++) {               // O(M)
            adj1.add(new ArrayList<>());
        }
        for (int[] edge : edges1) {                 // O(M-1)
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }

        // Build adjacency lists for tree 2     -> O(N + (N-1)) ~ O(N)
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {               // O(N)
            adj2.add(new ArrayList<>());
        }
        for (int[] edge : edges2) {                 // O(N-1)
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        // Part 1 : Find the best node in Tree-2        O(N^2)
        int best = 0;
        for (int i = 0; i < n; ++i) {                   // O(N)
            int connections = BFS(i, adj2, k - 1);     // O(V+E) and as adj2 has N nodes => O(N + (N-1)) ~ O(N)
            best = Math.max(best, connections);
        }

        // Part 2 : Build answer        O(M^2)
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {               // O(M)
            int connections = BFS(i, adj1, k);      // O(B+E) -> O(M + (M-1)) ~ O(M)
            res[i] = connections + best;
        }
        return res;
    }

    private int BFS(int start, List<List<Integer>> adj, int k) {            // O(V+E)
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; ++i) {
                int u = queue.poll();
                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        queue.add(v);
                        visited[v] = true;
                    }
                }
            }
            k--;
        }
        return count;
    }
}
