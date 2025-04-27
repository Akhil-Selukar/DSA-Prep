package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Topological sort
// O(N+E)/O(N+E)
public class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] res = new int[n];
        int[] indegree = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:richer){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Topological sort
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
            res[i] = i;
        }

        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int v:adj.get(u)){
                if(quiet[v] > quiet[u]){
                    quiet[v] = quiet[u];
                    res[v] = res[u];
                }
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }

        return res;
    }
}
