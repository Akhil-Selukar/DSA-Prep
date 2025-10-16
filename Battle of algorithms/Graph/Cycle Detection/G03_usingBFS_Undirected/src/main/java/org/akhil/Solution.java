package org.akhil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private class Vertex{
        int value;
        int parent;

        public Vertex(int value, int parent){
            this.value = value;
            this.parent = parent;
        }
    }

    public boolean detectCycle(List<List<Integer>> adj){
        if(adj == null || adj.size() == 0){
            return false;
        }

        boolean[] visited = new boolean[adj.size()];

        for(int i=0; i<adj.size(); i++){
            if(!visited[i]) {
                if (isCyclePresent(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclePresent(int i, List<List<Integer>> adj, boolean[] visited) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(new Vertex(i, -1));
        visited[i] = true;

        while(!queue.isEmpty()){
            Vertex polled = queue.poll();
            int val = polled.value;
            int parent = polled.parent;

            for(Integer neighbor:adj.get(val)){
                if(!visited[neighbor]){
                    queue.offer(new Vertex(neighbor, val));
                    visited[neighbor] = true;
                } else if(neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
