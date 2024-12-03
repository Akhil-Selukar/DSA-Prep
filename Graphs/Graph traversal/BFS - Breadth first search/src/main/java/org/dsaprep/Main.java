package org.dsaprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int numberOfVertex = 10;
        List<List<Integer>> adj = new ArrayList<>(numberOfVertex);

        // initializing adjacency list with empty arrays.
        for(int i=0; i<numberOfVertex; i++){
            adj.add(new ArrayList<>());
        }

        // adding edged in adjacency list
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 6);
        addEdge(adj, 3, 7);
        addEdge(adj, 5, 8);
        addEdge(adj, 6, 9);
        addEdge(adj, 8, 9);

        System.out.println(graphBFS(3, adj));
    }

    private static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);  // because of undirected graph
    }

    // Actual BFS code
    public static ArrayList<Integer> graphBFS(int v, List<List<Integer>> adj){
        ArrayList<Integer> traversal = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.offer(v);

        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
            traversal.add(currentVertex);

            for(int temp:adj.get(currentVertex)){
                if(!visited[temp]){
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
        return traversal;
    }
}