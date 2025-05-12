package org.akhil;


// Time complexity - O(E)
// Space complexity - O(N)
public class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet dsAlice = new DisjointSet(n);
        DisjointSet dsBob = new DisjointSet(n);
        int edgesRequired = 0;

        for(int[] edge:edges){
            if(edge[0] == 3) {
                if (dsAlice.unionBySize(edge[1], edge[2])) {
                    edgesRequired++;
                }
                dsBob.unionBySize(edge[1], edge[2]); // Bob also uses this edge
            }
        }

        for(int[] edge:edges){
            if(edge[0] == 2) {
                if (dsBob.unionBySize(edge[1], edge[2])) {
                    edgesRequired++;
                }
            }
        }

        for(int[] edge:edges){
            if(edge[0] == 1) {
                if (dsAlice.unionBySize(edge[1], edge[2])) {
                    edgesRequired++;
                }
            }
        }

        if(dsBob.isConnected() && dsAlice.isConnected()){
            return edges.length - edgesRequired;
        }

        return -1;
    }
}
