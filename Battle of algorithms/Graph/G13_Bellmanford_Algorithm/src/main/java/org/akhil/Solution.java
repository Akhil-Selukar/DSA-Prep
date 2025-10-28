package org.akhil;

public class Solution {
    public int[] bellmanFord(int noOfNodes, int[][] edges, int source) {        // we can get list<Edge> as well so modify as per that
        int[] dist = new int[noOfNodes];        // define dist array
        for(int i=0; i<noOfNodes; i++){         // assign infinite to all distance
            dist[i] = (int)1e9;
        }
        dist[source] = 0;                       // distance of source will be 0

        for(int i=0; i<noOfNodes-1; i++){       // n-1 times relaxation
            for(int[] edge:edges){              // relax each edge
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];

                if(dist[start] != (int)1e9 && dist[start] + weight < dist[end]){
                    dist[end] = dist[start] + weight;
                }
            }
        }

        // to check negative cycle 1 more iteration
        for(int[] edge:edges){
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            if(dist[start] != (int)1e9 && dist[start] + weight < dist[end]){
                // if we are able to find shorter distance that means there is a negative cycle
                return new int[]{-1};
            }
        }

        return dist;
    }
}
