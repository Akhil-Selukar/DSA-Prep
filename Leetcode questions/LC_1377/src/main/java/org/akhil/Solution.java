package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private class Node {
        int node;
        double probability;

        public Node(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }

    // Solution using BFS - O(N+E)/O(N+E)
    public double frogPosition(int n, int[][] edges, int t, int target) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // BFS
        boolean[] visited = new boolean[n+1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1.0));
        visited[1] = true;

        while (!queue.isEmpty() && t >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                int numNeighbors = countChild(adj.get(curr.node), visited);

                if (curr.node == target) {
                    if (numNeighbors == 0 || t == 0) {
                        return curr.probability;
                    }

                    return 0.0;
                }

                for (int next : adj.get(curr.node)) {
                    if (!visited[next]) {
                        double currProbability =  1.0 / ((double)numNeighbors);
                        queue.offer(new Node(next, curr.probability / numNeighbors));
                        visited[next] = true;
                    }
                }
            }
            t--;
        }
        return 0.0;
    }

    // O(Degree of node) degree of node = neighbors.size()
    // O(1)
    private int countChild(List<Integer> neighbors, boolean[] visited) {
        int count = 0;
        for (int n : neighbors) {
            if (!visited[n]) {
                count++;
            }
        }
        return count;
    }
}