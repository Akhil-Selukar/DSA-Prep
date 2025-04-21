package org.akhil;

public class Solution {

    // TC - ~O(N) - where N is number of vertices in the graph (considering time complexity of DS as O(4alpha) or amortised time complexity.)
    // SC - O(N)
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length + 1);     // +1 because graph vertices are starting from 1 and DS is 0 indexed.

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            if(!ds.unionBySize(u, v)){
                return edge;
            }
        }
        return new int[]{0,0};
    }
}
