package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<11; i++){
            adj.add(new ArrayList<>());
        }

        addEdges(adj, 1, 2);
        addEdges(adj, 2, 3);
        addEdges(adj, 3, 4);
        addEdges(adj, 3, 5);
        addEdges(adj, 4, 6);
        addEdges(adj, 6, 5);
        addEdges(adj, 6, 7);
        addEdges(adj, 8, 2);
        addEdges(adj, 8, 9);
        addEdges(adj, 9, 10);
        addEdges(adj, 10, 8);

        Solution solution = new Solution();

        System.out.println(solution.isCyclic(adj));
    }

    private static void addEdges(List<List<Integer>> adj, int i, int j){
        adj.get(i).add(j);
    }
}