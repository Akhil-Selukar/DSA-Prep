package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean isBipartite(List<List<Integer>> adj) {
        int[] colors = new int[adj.size()];

        Arrays.fill(colors, -1);

        for(int i=0; i<adj.size(); i++){
            if(colors[i] == -1){
                if(!checkBipartite(i, adj, colors, 0)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBipartite(int node, List<List<Integer>> adj, int[] colors, int colorVal){
        colors[node] = colorVal;

        for(int neighbor:adj.get(node)){
            if(colors[neighbor] == -1){
                if(!checkBipartite(neighbor, adj, colors, 1-colorVal)){
                    return false;
                }
            } else if(colors[neighbor] == colors[node]){
                return false;
            }
        }
        return true;
    }
}
