package org.akhil;

import java.util.*;

public class Solution {

    // Solution - bellman ford (O(V*E)/O(V))
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n+1];      // +1 because array is 0 indexed and our graph is 1 indexed.

        for(int i=0; i<dist.length; i++){
            dist[i] = (int)(1e9);
        }
        dist[k] = 0;    // starting at kth node

        for(int i=1; i<dist.length; i++){
            for(int[] edge:times){
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];

                if(dist[start] != (int)(1e9) && ((dist[start] + weight) < dist[end])){
                    dist[end] = (dist[start] + weight);
                }
            }
        }

        int minTime = 0;

        for(int i=1; i<dist.length; i++){       // i start from 1 because 0th index is of no use as graph is starting form 1.
            minTime = Math.max(minTime, dist[i]);
        }

        return (minTime == (int)(1e9)) ? -1 : minTime;
    }
}
