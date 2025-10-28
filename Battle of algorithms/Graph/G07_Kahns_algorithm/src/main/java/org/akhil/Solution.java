package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> topologicalSort(List<List<Integer>> adj){
        int[] inDegree = new int[adj.size()];

        for(int i=0; i<adj.size(); i++){
            for(int val:adj.get(i)){
                inDegree[val]++;
            }
        }

        // BFS based on inDegree
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<adj.size(); i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int polled = queue.poll();
            result.add(polled);

            for(int neighbor:adj.get(polled)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
}
