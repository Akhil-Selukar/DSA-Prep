package org.akhil;

public class Solution2 {
    public int findCircleNum(int[][] adj) {
        DisjointSet ds = new DisjointSet(adj.length);

        for(int i=0; i< adj.length; i++){
            for(int j=0; j<adj.length; j++){
                if(adj[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for(int i=0; i<adj.length; i++){
            if(i == ds.findParent(i)){
                count++;
            }
        }

        return count;
    }
}