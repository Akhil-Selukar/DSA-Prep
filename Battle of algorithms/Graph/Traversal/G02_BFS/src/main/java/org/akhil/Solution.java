package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<Integer> graphBFS(int startVertex, List<List<Integer>> adj){
        List<Integer> result = new ArrayList<>();
        if(adj == null || adj.size() == 0 || startVertex >= adj.size()){
            return result;
        }

        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visited[startVertex] = true;

        while(!queue.isEmpty()){
            int polled = queue.poll();
            result.add(polled);

            for(int neighbor:adj.get(polled)){
                if(!visited[neighbor]){
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return result;
    }
}
