package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<6; i++){
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 2);

        Solution solution = new Solution();
        System.out.println(solution.isCyclic(adj));
    }

    private static void addEdge(List<List<Integer>> adj, int i, int j){
        adj.get(i).add(j);
    }
}