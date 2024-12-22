package org.dsaprep;

public class BellmanFord {
    public int[] bellmanFord(int noOfNodes, int[][] edges, int source) {
        int[] dist = new int[noOfNodes];
        for(int i=0; i<dist.length; i++){
            dist[i] = (int)1e9;
        }
        dist[source] = 0;

        for(int i=0; i<noOfNodes-1; i++){
            for(int[] edge:edges){
                int startNode = edge[0];
                int endNode = edge[1];
                int edgeWeight = edge[2];

                if(dist[startNode] != (int)1e9 && dist[startNode]+edgeWeight < dist[endNode]){
                    dist[endNode] = dist[startNode] + edgeWeight;
                }
            }
        }
        // If just asked to find the distance then return dist array now, but if asked to detect the negative cycle then perform another iteration like below.

        for(int[] edge:edges){
            int startNode = edge[0];
            int endNode = edge[1];
            int edgeWeight = edge[2];

            if(dist[startNode] != (int)1e9 && dist[startNode]+edgeWeight < dist[endNode]){
                return new int[]{-1};   // that means negative cycle is present
            }
        }

        return dist;
    }
}
