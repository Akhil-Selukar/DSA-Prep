package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // question link - https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
    public static void main(String[] args) {
        int noOfNodes = 3;
        int noOfEdges = 3;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<noOfEdges; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new int[]{0,1,5});
        adj.get(0).add(new int[]{0,2,1});

        adj.get(1).add(new int[]{1,0,5});
        adj.get(1).add(new int[]{1,2,3});

        adj.get(2).add(new int[]{2,0,1});
        adj.get(2).add(new int[]{2,1,3});

        Solution solution = new Solution();

        System.out.println(solution.spanningTree(noOfNodes, noOfEdges, adj));
    }
}