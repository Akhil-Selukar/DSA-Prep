package org.akhil;

import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int minTime = 0;

        // create adj list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n+1; i++){
            adj.add(new ArrayList<int[]>());
        }

        for(int i=0; i<times.length; i++){
            int source = times[i][0];
            int desti = times[i][1];
            int weight = times[i][2];

            adj.get(source).add(new int[]{desti, weight});
        }

        // bfs
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> (b[1]-a[1]));
        queue.offer(new int[]{k,0});
        boolean[] visited = new boolean[n+1];

        while(!queue.isEmpty()){
            int polled[] = queue.poll();
            int polledVal = polled[0];
            int maxTimeNeeded = 0;

            if(!visited[polledVal]){
                visited[polledVal] = true;
                for(int[] neighbour:adj.get(polledVal)){
                    int val = neighbour[0];
                    int weight = neighbour[1];

                    if(!visited[val]){
                        maxTimeNeeded = Math.max(maxTimeNeeded, weight);
                        queue.offer(new int[]{val, weight});
                    }
                }
                minTime = minTime + maxTimeNeeded;
            }
        }
        return (minTime == 0) ? -1 : minTime;
    }
}
