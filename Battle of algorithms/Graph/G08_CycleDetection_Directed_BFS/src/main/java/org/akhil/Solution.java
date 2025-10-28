package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Cycle detection in directed graph using BFS is simple, we just need to find topological sort (Kahn's algorithm)
    If topological sorting order is present that means no cycle and if topological sorting is not possible that means we have a cycle.
 */
public class Solution {
    public boolean isCyclic(List<List<Integer>> adj) {
        int[] inDegree = new int[adj.size()];

        for(List<Integer> neighbors:adj){
            for(int neighbor:neighbors){
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<adj.size(); i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        // List<Integer> topoSort = new ArrayList<>();         // No need to find actual sorting order, just count of elements will also be fine
        int valInTopoSort = 0;

        while(!queue.isEmpty()){
            int polled = queue.poll();
            valInTopoSort++;        // the polled value will be in topoSort

            for(int neighbor:adj.get(polled)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        // check if all elements in graph are there in topo sort or not
        if(valInTopoSort == adj.size()){
            return false;       // no cycle present
        }
        return true;        // cycle present
    }
}
