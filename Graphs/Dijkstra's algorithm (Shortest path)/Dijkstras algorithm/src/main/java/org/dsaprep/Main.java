package org.dsaprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList();
        for(int i=0; i<6; i++){
            adj.add(new ArrayList());
        }

        createEdges(adj, 0, 1, 4);
        createEdges(adj, 1, 2, 2);
        createEdges(adj, 0, 2, 4);
        createEdges(adj, 2, 3, 3);
        createEdges(adj, 2, 4, 1);
        createEdges(adj, 2, 5, 6);
        createEdges(adj, 3, 5, 6);
        createEdges(adj, 4, 5, 3);

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dijkstra(adj, 0)));
    }

    private static void createEdges(List<List<Pair>> adj, int i, int j, int w){
        adj.get(i).add(new Pair(j, w));
        adj.get(j).add(new Pair(i, w));
    }
}