package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<9; i++){
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 4);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        addEdge(adj, 4, 7);
        addEdge(adj, 7, 8);

//        addEdge(adj, 1, 2);
//        addEdge(adj, 2, 3);
//        addEdge(adj, 2, 5);
//        addEdge(adj, 3, 4);
//        addEdge(adj, 5, 6);
//        addEdge(adj, 4, 6);
//        addEdge(adj, 6, 7);

        Bipartite bpt = new Bipartite();
        System.out.println(bpt.isBipartite(adj));

    }

    private static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
}