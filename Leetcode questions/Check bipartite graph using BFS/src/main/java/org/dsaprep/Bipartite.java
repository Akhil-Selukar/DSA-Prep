package org.dsaprep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite {

    public boolean isBipartite(List<List<Integer>> adj){
        int[] colors = new int[adj.size()];

        // setting all colors to -1 as we will alternately fill 0 and 1.
        Arrays.fill(colors, -1);

        for(int i=0; i<adj.size(); i++){
            if(colors[i] == -1){
                if (!bipartiteCheck(adj, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bipartiteCheck(List<List<Integer>> adj, int[] colors, int val){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(val);
        colors[val] = 0;

        while(!queue.isEmpty()){
            int tempVal = queue.poll();

            for(int adjacentNode:adj.get(tempVal)){
                if(colors[adjacentNode] == -1){                // If no color is assigned to adjacent node then assign color and add in queue.
                    colors[adjacentNode] = 1-colors[tempVal];
                    queue.offer(adjacentNode);
                } else if(colors[adjacentNode] == colors[tempVal]){     // if colors of adjacent nodes are equal then not a bipartite graph.
                    return false;
                }
            }
        }
        return true;
    }
}
