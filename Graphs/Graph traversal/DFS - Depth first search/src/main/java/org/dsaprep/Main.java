package org.dsaprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int numberOfVertex = 9;
        List<List<Integer>> adj = new ArrayList<>(numberOfVertex);

        // initialize adjacency list
        for(int i=0; i<numberOfVertex; i++){
            adj.add(new ArrayList<>());
        }

        // populate the graph
        addEdge(adj, 1,2);
        addEdge(adj, 1,3);
        addEdge(adj, 2,5);
        addEdge(adj, 2,6);
        addEdge(adj, 3,4);
        addEdge(adj, 3,7);
        addEdge(adj, 4,8);
        addEdge(adj, 8,7);

        System.out.println(DFSTraversal(3, adj));
    }

    private static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    // Actual DFS traversal
    public static List<Integer> DFSTraversal(int startVertex, List<List<Integer>> adj){
        List<Integer> traversal = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        helper(traversal, adj, visited, startVertex);

        return traversal;
    }

    private static void helper(List<Integer> traversal, List<List<Integer>> adj, boolean[] visited, int vertex) {
        visited[vertex] = true;

        traversal.add(vertex);

        for(Integer temp:adj.get(vertex)){
            if(!visited[temp]){
                helper(traversal,adj, visited, temp);
            }
        }
    }
}