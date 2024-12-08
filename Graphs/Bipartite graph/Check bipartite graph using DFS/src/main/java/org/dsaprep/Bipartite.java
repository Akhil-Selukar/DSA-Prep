package org.dsaprep;

import java.util.Arrays;
import java.util.List;

public class Bipartite {

    public boolean isBipartite(List<List<Integer>> adj) {
        int[] colors = new int[adj.size()];

        Arrays.fill(colors, -1);

        for(int i=0; i<adj.size(); i++){
            if(colors[i] == -1){
                if(!bipartiteDFS(adj, colors, 0, i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bipartiteDFS(List<List<Integer>> adj, int[] colors, int color, int val){
        colors[val] = color;

        for(int adjacentNode:adj.get(val)){
            if(colors[adjacentNode] == -1){
                if(!bipartiteDFS(adj, colors, 1-color, adjacentNode)){
                    return false;
                }
            } else if(colors[adjacentNode] == colors[val]){
                return false;
            }
        }
        return true;
    }
}
