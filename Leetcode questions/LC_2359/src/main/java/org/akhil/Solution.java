package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(N)/O(N)
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] distFromN1 = getDistanceToAllNode(edges, node1);
        int[] distFromN2 = getDistanceToAllNode(edges, node2);

        int min = Integer.MAX_VALUE;
        int res = -1;

        for(int i=0; i<edges.length; i++){
            if(distFromN1[i] >= 0 && distFromN2[i] >= 0){
                int maxOfTwo = Math.max(distFromN1[i], distFromN2[i]);
                if(maxOfTwo < min){
                    min = maxOfTwo;
                    res = i;
                }
            }
        }
        return res;
    }

    private int[] getDistanceToAllNode(int[] edges, int node) {
        boolean[] visited = new boolean[edges.length];
        int[] distance = new int[edges.length];
        Arrays.fill(distance, -1);
        int dist = 0;

        while(node >= 0 && !visited[node]){
            distance[node] = dist;
            visited[node] = true;
            dist++;
            node = edges[node];
        }
        return distance;
    }
}
