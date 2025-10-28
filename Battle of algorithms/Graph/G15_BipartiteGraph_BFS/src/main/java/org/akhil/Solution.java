package org.akhil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean isBipartite(List<List<Integer>> adj){
        int[] color = new int[adj.size()];
        Arrays.fill(color, -1);

        for(int i=0; i<adj.size(); i++){
            if(color[i] == -1){
                if(!checkBipartite(i, color, adj)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBipartite(int node, int[] color, List<List<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = 0;

        while(!queue.isEmpty()){
            int polled = queue.poll();
            for(int neighbor:adj.get(polled)) {
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - color[polled];
                    queue.offer(neighbor);
                } else if(color[neighbor] == color[polled]) {
                    return false;
                }
            }
        }
        return true;
    }
}
