package org.akhil;

import java.util.Arrays;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1) {
                if (!checkBipartite(graph, color, i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkBipartite(int[][] graph, int[] color, int node, int col) {
        color[node] = col;

        for(int neighbour:graph[node]){
            if(color[neighbour] == -1){
                if(!checkBipartite(graph, color, neighbour, 1-col)){
                    return false;
                }
            } else if(color[neighbour] == col){
                return false;
            }
        }

        return true;
    }
}
