package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        // create adjacency list and inDegree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n+1];

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] relation:relations){
            adj.get(relation[0]).add(relation[1]);
            inDegree[relation[1]]++;
        }

        // create a visited array and queue
        Queue<Integer> queue = new LinkedList<>();
//        boolean[] visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        // use topological sort logic
        int semCount = 0;

        while(!queue.isEmpty()){
            int nodesToPoll = Math.min(queue.size(), k);

            for(int i=0; i<nodesToPoll; i++){
                int polled = queue.poll();
//                visited[polled] = true;

                for(int neighbor:adj.get(polled)){
                    inDegree[neighbor]--;

                    if(inDegree[neighbor] == 0){
                        queue.offer(neighbor);
                    }
                }
            }
            semCount++;
        }

        return semCount;
    }
}
