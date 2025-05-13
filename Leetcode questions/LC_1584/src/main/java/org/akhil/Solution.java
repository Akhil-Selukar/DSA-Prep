package org.akhil;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    // O(N^2 logN)/O(N)
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);    // O(1)
        Map<Integer, Integer> minDist = new HashMap<>();

        // starting from 0th point in given points array.
        queue.offer(new int[]{0, 0});       // [weight, node];      // O(logN)
        int minCost = 0;

//        int i=1;
        // overall while loop O(N^2 logN)
        while(!queue.isEmpty()){            // O(N)
//            System.out.println("Iteration No -> "+i++);
            int[] polled = queue.poll();        // O(logN)
            int cost = polled[0];
            int u = polled[1];

            if(visited[u]){
                continue;
            }

            visited[u] = true;
            minCost = minCost + cost;

            for(int v=0; v<n; v++){     // exploring all other points from current point.   O(N)
                if(!visited[v]){
                    int distToAdjPoint = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if(distToAdjPoint < minDist.getOrDefault(v, Integer.MAX_VALUE)){       // to reduce the iterations over queue (i.e. to not add greater distance if we already has small distance to a point present) code will work fine without this map as well but the number rof iteration will be more in that case.
                        queue.offer(new int[]{distToAdjPoint, v});
                        minDist.put(v, distToAdjPoint);
                    }
                }
            }

        }

        return minCost;
    }
}
