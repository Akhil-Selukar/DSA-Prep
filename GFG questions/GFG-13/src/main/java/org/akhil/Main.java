package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<9; i++){
            adj.add(new ArrayList<>());
        }

        addEdges(adj, 0, 1);
        addEdges(adj, 0, 3);
        addEdges(adj, 1, 3);
        addEdges(adj, 1, 2);
        addEdges(adj, 3, 4);
        addEdges(adj, 4, 5);
        addEdges(adj, 2, 6);
        addEdges(adj, 5, 6);
        addEdges(adj, 6, 7);
        addEdges(adj, 6, 8);
        addEdges(adj, 7, 8);

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestPath(adj, 9, 11, 0)));
    }

    private static  void addEdges(List<List<Integer>> adj, int i, int j){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
}